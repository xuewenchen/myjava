package thread;

class NewThread implements Runnable {

    Thread t;
    NewThread() {
        t = new Thread(this, "Demo Thread");
        System.out.println("child thread:"+ t);
        t.start();
    }

    // 第二个线程入口
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                // 暂停线程
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
    }
}

public class ThreadDemo {
    public  static void main(String []args) {
        new NewThread(); // 创建一个新线程
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }
}
