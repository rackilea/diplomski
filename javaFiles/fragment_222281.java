import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class Counter implements Runnable {
    private static AtomicInteger counter = new AtomicInteger(0);
    private static final Object lock = new Object();
    private static final int limit = 1000;
    private static final int threadPoolSize = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        for (int i = 0; i < threadPoolSize; i++) {
            executorService.submit(new Counter());
        }
        executorService.shutdown();
    }

    @Override
    public void run() {
        incrementCounter();
    }

    private void incrementCounter() {
        synchronized (lock) {
            while (counter.get() < limit) {
                System.out.println(Thread.currentThread().getName() + " : " + counter.get());
                counter.incrementAndGet();
            }
        }
    }
}