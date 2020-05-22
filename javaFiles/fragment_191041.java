private static Process launchProcess(ProcessBuilder builder) throws IOException {
  final CountDownLatch latch = new CountDownLatch(1);
  // ...
  new Thread(() -> {
    try {
      process.set(builder.start());
      latch.countDown();
      //...
    } catch (IOException e) {
      //...
    }
  }).start();

  latch.await();
  return process.get();
}