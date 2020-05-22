private final ExecutorService executor;
private final TimeLimiter timeLimiter;

...
executor = Executors.newCachedThreadPool();
timeLimiter = new SimpleTimeLimiter(executor);
...

public void shutdown() {
  if (executor == null || executor.isShutdown()) {
    return;
  }
  executor.shutdown();
  try {
    executor.awaitTermination(5, TimeUnit.SECONDS);
  } catch (InterruptedException e) {
    log.log(Level.WARNING, "Interrupted during executor termination.", e);
    Thread.currentThread().interrupt();
  }
  executor.shutdownNow();
}