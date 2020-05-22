// create a thread pool with 5 workers
ExecutorService threadPool = Executors.newFixedThreadPool(5);
// submit all of your jobs here
for (int i = 0; i < 500; i++) {
    threadPool.submit(new MyJob(i));
}
// once we have submitted all jobs to the thread pool, it should be shutdown
threadPool.shutdown();
// if you need to wait for the pool you can do
threadPool.awaitTerminatation(Long.MAX_VALUE, TimeUnit.MILLISECONDS);