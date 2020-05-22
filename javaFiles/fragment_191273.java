import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(final String[] args) throws InterruptedException {
        final ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(() -> {
            method1();
            method2();
        });

        pool.execute(() -> {
            method3();
            /* ... */
            method8();
        });

        pool.shutdown();

        if (!pool.awaitTermination(1, TimeUnit.DAYS))
            System.err.println("Pool did not terminate.");
    }
}