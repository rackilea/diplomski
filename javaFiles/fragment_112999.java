import java.util.concurrent.CompletableFuture;

public class Futures {

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<Void> c = CompletableFuture.runAsync(() -> {

            System.out.println("run1: " + Thread.currentThread().getId());
        });

        c.whenComplete((r, t) -> {
            System.out.println("I'm completed");
        });

        c.thenCompose(__ -> {
            System.out.println("thenCompose1: " + Thread.currentThread().getId());
            return CompletableFuture.runAsync(() -> {
                System.out.println("run2: " + Thread.currentThread().getId());
            });
        }).thenRunAsync(() -> {
            System.out.println("RunAsync1: " + Thread.currentThread().getId());
        });

        Thread.sleep(5000);

        System.out.println("Finished");
    }
}