CountdownLatch latch = new CountdownLatch(1);
ExecutorService executor = Executors.newFixedThreadPool(20);
for (int i = 0; i < 20; ++i) {
  executor.execute(() -> {
    latch.await();  // exception handling omitted for clarity.
    System.out.println("...");
  });
}
latch.countdown();
executor.shutdown();