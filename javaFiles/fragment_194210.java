public class Main {
    static boolean turn = false; // false is even, true is odd

    public static void main(String[] args) {
        Object o = new Object();
        Thread tEven = new Thread(new EvenThread(o));
        Thread tOdd = new Thread(new OddThread(o));

        tEven.start();
        tOdd.start();
    }

    // TODO some inheritance with [Even/Odd]Thread

    static class EvenThread implements Runnable {
        Object o;

        EvenThread(Object o) {
            this.o = o;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 10; i += 2) {
                synchronized (o) {
                    try {
                        while (turn) {
                            o.wait();
                        }
                    }
                    catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    finally {
                        System.out.println(i);
                        turn = !turn;
                        o.notifyAll();
                    }
                }
            }
        }
    }

    static class OddThread implements Runnable {
        Object o;

        OddThread(Object o) {
            this.o = o;
        }

        @Override
        public void run() {
            for (int i = 1; i < 10; i += 2) {
                synchronized (o) {
                    try {
                        while (!turn) {
                            o.wait();
                        }
                    }
                    catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    finally {
                        System.out.println(i);
                        turn = !turn;
                        o.notifyAll();
                    }
                }
            }
        }
    }
}