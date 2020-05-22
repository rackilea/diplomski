@Test
public void threadCounter() throws Throwable {
    ThreadLocal<Integer> number = new ThreadLocal<Integer>() {
        private final AtomicInteger values = new AtomicInteger();

        @Override
        protected Integer initialValue() {
            return values.getAndIncrement();
        }
    };

    ExecutorService threadPool = Executors.newFixedThreadPool(100);

    for (int i = 0 ; i < 500 ; i++) {
        final int count = i;
        threadPool.submit(() -> System.out.printf("%-4s : %-20s - %s\n", count, Thread.currentThread().getName(), number.get()));
    }

    threadPool.shutdown();
    threadPool.awaitTermination(10, TimeUnit.SECONDS);

    Assert.assertEquals(100, number.get().intValue());

}