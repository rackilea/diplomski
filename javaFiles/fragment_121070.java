import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example {

    public static void main(String[] args) {

        Example example = new Example();

        // Start generating a String
        ExecutorService pool = Executors.newFixedThreadPool(4);     // We need some pool to run things async
        CompletableFuture.supplyAsync(example::createString, pool)  // run the creation job in another thread
                         .thenAccept(example::callback);            // run this callback when the job is done
        pool.shutdown();

        // Doing something else in the meantime...
        System.out.println("Meandering...");

    }

    private String createString() {
        artificialDelay();
        return "Hello World";
    }

    private void callback(String input) {
        System.out.println("Received this : " + input);
    }

    private void artificialDelay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}