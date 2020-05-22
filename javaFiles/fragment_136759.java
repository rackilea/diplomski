ConcurrentMap<String, CompletableFuture<Void>> dispatchQueues = ...

public CompletableFuture<Void> dispatch(String queueName, Runnable task) {
  return dispatchQueues.compute(queueName, (k, queue) -> {
    return (queue == null)
        ? CompletableFuture.runAsync(task)
        : queue.thenRunAsync(task);
  });
}