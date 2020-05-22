public class MyCompletableFuture<T> extends CompletableFuture<T> {
    static final Executor EXEC = r -> {
        System.out.println("executing "+r);
        new Thread(r).start();
    };

    @Override
    public Executor defaultExecutor() {
        return EXEC;
    }

    @Override
    public <U> CompletableFuture<U> newIncompleteFuture() {
        return new MyCompletableFuture<>();
    }

    public static CompletableFuture<Void> runAsync​(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return supplyAsync(() -> {
            runnable.run();
            return null;
        });
    }

    public static <U> CompletableFuture<U> supplyAsync​(Supplier<U> supplier) {
        return new MyCompletableFuture<U>().completeAsync(supplier);
    }
}