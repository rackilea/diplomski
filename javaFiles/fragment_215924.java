public class Threads {
    private final Object lock = new Object();
    private volatile boolean flag;

    class RunnableA implements Runnable {
        private volatile boolean condition = false;
        @Override
        public void run() {
            while (true) {
                if (condition) {
                    if (!flag) {
                        synchronized (lock) {
                            System.out.println("Setting Flag to True");
                            flag = true;
                            lock.notifyAll();
                        }
                    }
                } else {
                    System.out.println("Condition is False");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        }
    }

    class RunnableB implements Runnable {
        @Override
        public void run() {
            while (true) {
                while (flag == false) {
                    synchronized (lock) {
                        if (flag == false) {
                            try {
                                lock.wait();
                            } catch (InterruptedException ex) {

                            }
                        }
                    }
                }
                System.out.println("Kaboom");
            }
        }
    }

    public void run() {
        RunnableA runnableA = new RunnableA();
        RunnableB runnableB = new RunnableB();
        Thread t1 = new Thread(runnableA);
        Thread t2 = new Thread(runnableB);
        t1.start();
        t2.start();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException ex) {

        }
        runnableA.condition = true;

    }
    public static void main(String[] args) {
        new Threads().run();
    }
}