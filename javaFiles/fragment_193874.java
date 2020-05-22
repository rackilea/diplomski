public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        final CountDownLatch latch = new CountDownLatch(10);

        IntStream.range(0, 10).forEach(i ->
                executor.submit(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("Hello");
                    } catch (InterruptedException e) {
                        throw new IllegalStateException("Task interrupted", e);
                    } finally {
                        latch.countDown();
                    }
                })
        );

        latch.await();


    }
}