class PromiseImpl<T> implements Promise<T> {

    private CompletableFuture<T> future;

    public PromiseImpl(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public <U> Promise<U> thenApply(Function<T, U> function) {
        return new PromiseImpl<>(this.future.thenApply(function));
    }

    @Override
    public Promise<Void> thenAccept(Consumer<T> consumer) {
        return new PromiseImpl<>(this.future.thenAccept(consumer));
    }

    private void onResult(T result) {
        this.future.complete(result);
    }

    private Object doWork(T result) {
        onResult(result);
        return null;
    }
}