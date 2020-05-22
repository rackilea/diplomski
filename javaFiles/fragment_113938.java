import java.util.concurrent.atomic.AtomicInteger;

class DoThread implements Runnable {

    private final AtomicInteger counter;

    DoThread(AtomicInteger counter) {
        this.counter = counter;
    }

    public void run() {
        counter.incrementAndGet();
    }
}

public class Test {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger shared = new AtomicInteger(0);

        Thread t1 = new Thread(new DoThread(shared));
        Thread t2 = new Thread(new DoThread(shared));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(shared.get()); // Prints 2
    }
}