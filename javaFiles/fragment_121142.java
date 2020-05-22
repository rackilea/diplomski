public void test1() {
    try {
        AtomicInteger atomicInt = new AtomicInteger(0);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        IntStream.range(0,1000).forEach(i->executor.submit( atomicInt::incrementAndGet ));

        executor.shutdown();
        // Wait a maximum of ~a million billion years
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);

        System.out.println("test1 result = "+ atomicInt.get());
    }
    catch (InterruptedException ex)
    {
        // Oh no!
    }
}