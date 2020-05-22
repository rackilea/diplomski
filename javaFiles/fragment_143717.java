try {
  long endTime = System.nanoTime() + TimeUnit.SECONDS.toNanos(30);
  while (true) {
    long timeout = Math.min(
        TimeUnit.SECONDS.toNanos(1), endTime - System.nanoTime());
    if (timeout <= 0
        || executor.awaitTermination(timeout, TimeUnit.NANOSECONDS)) {
      break;
    }
    System.err.println("Still waiting for timeout");
  }
} catch (InterruptedException e) {
  logger.error(e);
  Thread.currentThread().interrupt();
}