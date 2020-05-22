public class DaemonsAtPlay {

    public static void thenComposeWithSleep() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Slept"; //HERE
        }).thenCompose(value -> CompletableFuture.supplyAsync(() -> value + " Then compose is been called"));
        completableFuture.thenAccept(DaemonsAtPlay::report); //HERE
    }

    public static void thenCompose() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(value -> CompletableFuture.supplyAsync(() -> value + " Then compose is been called"));
        completableFuture.thenAccept(DaemonsAtPlay::report); //HERE
    }

    private static final AtomicInteger counter = new AtomicInteger();

    static void report(String msg) {
        System.out.println("report: " + counter.incrementAndGet() + "; message: >" + msg + "<");
    }

    public static void executeMultiple(int iterations, boolean withsleep) {
        for(int i=0; i<iterations; ++i) {
            if(withsleep) {
                thenComposeWithSleep();
            } else {
                thenCompose();
            }
        }
    }

    public static void main(String... none) throws Exception {
        executeMultiple(100, false);
        executeMultiple(100, true);
        report("exiting main");
    }
}