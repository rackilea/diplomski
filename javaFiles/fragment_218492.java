public class RunnableCompletableFuture<T> extends CompletableFuture<T> implements RunnableFuture<T> {
    private final Callable<T> task;

    public RunnableCompletableFuture(Callable<T> task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            complete(task.call());
        } catch (Exception e) {
            completeExceptionally(e);
        }
    }
}