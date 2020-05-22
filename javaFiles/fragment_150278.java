public class Main {

    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        alphabet1 alpha = new alphabet1();
        new Thread(alpha).start();
    }

    static class alphabet1 implements Runnable {

        @Override
        public void run() {

            System.out.println("A");
            System.out.println("B");
            System.out.println("C");
            System.out.println("D");

            try {
                synchronized (LOCK) {
                    alphabet2 alpha2 = new alphabet2();
                    new Thread(alpha2).start();
                    LOCK.wait();
                }
            } catch (InterruptedException | IllegalMonitorStateException e) {
                e.printStackTrace();
            }

            System.out.println("G");
            System.out.println("H");

            try {
                synchronized (LOCK) {
                    LOCK.notifyAll();
                }
            } catch (IllegalMonitorStateException e) {
                e.printStackTrace();
            }
        }
    }

    static class alphabet2 implements Runnable {

        @Override
        public void run() {

            System.out.println("E");
            System.out.println("F");

            try {
                synchronized (LOCK) {
                    LOCK.notifyAll();
                    LOCK.wait();
                }
            } catch (InterruptedException | IllegalMonitorStateException e) {
                e.printStackTrace();
            }

            System.out.println("I");
        }
    }
}