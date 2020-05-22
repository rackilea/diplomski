static void doWorkSync(Worker worker) {
  final CountDownLatch latch = new CountDownLatch(1);
  worker.doWorkAsync(() -> latch.countDown());
  try {
    latch.await();
  } catch (InterruptedException e) {
    throw new AssertionError(e);
  }
}