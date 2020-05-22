// a pool of 10 threads
ExecutorService threadPool = Executors.newFixedThreadPool(10);
// submit a bunch of jobs to they 10 threads for processing
for (MyJob job : jobsToDo) {
   threadPool.submit(job);
}
// no more tasks are being submitted so shutdown the pool
threadPool.shutdown();
// wait for the jobs to finish
threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);