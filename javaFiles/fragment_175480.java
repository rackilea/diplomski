ExecutorService executor = Executors.newSingleThreadExecutor();
Runnable task = new Runnable() {
  public void run() {
    throw new RuntimeException("foo");
  }
};

Future<?> future = executor.submit(task);
try {
  future.get();
} catch (ExecutionException e) {
  Exception rootException = e.getCause();
}