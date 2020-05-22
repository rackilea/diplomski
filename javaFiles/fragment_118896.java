public static void main(String[] args) throws InterruptedException {

    final ExecutorService executorService = Executors.newSingleThreadExecutor();
    final CountDownLatch countDownLatch = new CountDownLatch(1);
    executorService.execute(new ThreadCounter(countDownLatch));
    countDownLatch.await(5, TimeUnit.SECONDS);

    executorService.shutdown();
}