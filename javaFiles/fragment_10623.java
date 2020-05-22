@Test
public void test() throws Exception {
    int numThreads = 10;
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);
    for (int i = 0; i < numThreads; i++) {
        executor.execute(new GPSService());
    }
    executor.shutdown();
    while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
        // Threads are still running
    }
    // All threads are completed
}