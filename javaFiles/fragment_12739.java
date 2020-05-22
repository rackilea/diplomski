public class Counter {
    private volatile int counter;

    public void increment() {
        counter = counter + 1;
    }

    private int get() {
        return counter;
    }
}