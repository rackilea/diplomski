public void test1() {
    AtomicInteger atomicInt = new AtomicInteger(0);

    ExecutorService executor = Executors.newSingleThreadExecutor();                
    IntStream.range(0,1000).forEach(i->executor.submit( atomicInt::incrementAndGet ));

    // All threads submitted (not necessarily finished)

    System.out.println("test1 result = "+ atomicInt.get());

    executor.shutdown();

    // Threads are still not necessarily done
}