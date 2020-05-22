// create a thread pool with some number of workers chosen by the user
ExecutorService threadPool = Executors.newFixedThreadPool(numThreadsInPool);
for (MyRunnable job : runnablesToDo) {
   threadPool.submit(job);
}
// once we have submitted all jobs to the thread pool, it should be shutdown
threadPool.shutdown();