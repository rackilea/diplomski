public class Counter {
    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void decrement() {
        this.value--;
    }

    public int getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        new Simulation().start();
    }
}

class Cell extends Thread {

    private Object sync;
    private Counter counter;

    public Cell(Object sync, Counter counter) {
        this.sync = sync;
        this.counter = counter;
    }

    public void run() {
        for (int r = 0; r < Simulation.ROUND_NUM; r++) {

            // do something

            synchronized (sync) {
                synchronized (counter) {
                    counter.decrement();
                    counter.notifyAll();
                }
                try {
                    sync.wait();
                } catch (Exception ignored) {}
            }


        }
    }
}

class Simulation extends Thread {

    public static final int THREAD_NUM = 900;
    public static final int ROUND_NUM = 30;

    public Object sync = new Object();
    private Counter counter = new Counter(THREAD_NUM);

    public void run() {

        for (int i = 0; i < THREAD_NUM; i++) {
            Cell c = new Cell(sync, counter);
            c.start();
        }

        for (int i = 0; i < ROUND_NUM; i++) {
            synchronized (counter) {
                while (counter.getValue() != 0) {
                    try {
                        counter.wait();
                    } catch (Exception ex) {
                    }
                }
                counter.setValue(THREAD_NUM);
            }

            synchronized (sync) {
                sync.notifyAll();
            }
        }
    }
}