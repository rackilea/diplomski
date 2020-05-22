public class Adder implements Runnable {

    int a;
    static AtomicInteger total = new AtomicInteger(0);

    public Adder(int a) {
        this.a = a;
    }

    public int getTotal() {
        return total.get();
    }

    @Override
    public void run() {
        // return value is ignored
        total.addAndGet(a);
    }
}