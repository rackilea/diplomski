public class WaitNotifyTest{


    public static void main(String[] args) {
        Object lock=new Object(); 
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + " is running");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " is waken up");
                    }
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        try {
                            Thread.sleep(3000);
                            System.out.println(Thread.currentThread().getName() + " is running");
                            lock.notify();
                            System.out.println(Thread.currentThread().getName() + " notifying");
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
            t1.start();
            t2.start();
        }
    }