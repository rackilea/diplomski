ExecutorService executor = Executors.newFixedThreadPool(10);
for (final Object item : collectionThingy) {
  executor.submit(new Runnable() {
    @Override
    public void run() {
      // do stuff with item
    }
  });
}
executor.shutdown();
executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);