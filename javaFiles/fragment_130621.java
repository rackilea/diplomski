import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        final CountingRunnable countingRunnable = new CountingRunnable();
        final List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            final Thread thread = new Thread(countingRunnable);
            threads.add(thread);
            thread.start();
        }

        for (final Thread thread : threads) {
            thread.join();
        }
    }

    private static final class CountingRunnable implements Runnable {
        private final AtomicInteger count = new AtomicInteger(0);

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(count.incrementAndGet());
            }
        }
    }
}