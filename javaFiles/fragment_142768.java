// this starts a thread-pool with 1 thread
ExecutorService threadPool = Executors.newFixedThreadPool(1);
for (File f : files) {
    // you can submit many files but only 1 thread will process them
    threadPool.submit(new ImageRunnable(file));
}
// once we have submitted all jobs to the thread pool, it should be shutdown
threadPool.shutdown();