// create a thread pool with 10 threads, this can be optimized to your hardware
ExecutorService threadPool = Executors.newFixedThreadPool(10);
// submit your handlers to the thread-pool
for (PCHandler handler : handlersToDo) {
    threadPool.submit(handler);
}
// once we have submitted all jobs to the thread pool, it should be shutdown
threadPool.shutdown();
...