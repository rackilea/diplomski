class Job<T> {
    private final Supplier<T> computation;
    private final CompletableFuture<T> future;

    Job(Supplier<T> computation, CompletableFuture<T> future) {
        this.future = future;
        this.computation = computation;
    }

    public Supplier<T> getComputation() {
        return computation;
    }

    public CompletableFuture<T> getFuture() {
        return future;
    }
}

public void client() {
    // on the client:
    CompletableFuture<String> future = new CompletableFuture<>();
    Supplier<String> computation = () -> "Here I am!";

    enqueue(new Job<>(computation, future));

    String resultString = future.get();
}

public <T> void server(Job<T> job) {
    // on the server; job is taken from the queue
    CompletableFuture<T> future = job.getFuture();
    future.complete(job.getComputation().get());
}