public class Main {

    public class ExampleThread extends Thread {

        public ExampleThread() {
            System.out.println("ExampleThread's name is: " + this.getName());
        }

        @Override
        public void run() {
            synchronized (this) {
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                }
            }
            for(int i = 1; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        new Main().go();
    }

    public void go() {
        Thread t = new ExampleThread();
        synchronized (t) {
            t.start();
            try {
                t.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        for(int i = 1; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(i);
        }

        synchronized(t) {
            t.notify();
        }
    }
}