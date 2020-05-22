// create a thread pool with 10 workers
ExecutorService threadPool = Executors.newFixedThreadPool(10);
while(!shutdown) {
   // receive a request from your service -- this is tricky
   // process it using the thread pool
   threadPool.submit(new MyRequest(...));
}
...
// once we have submitted all jobs to the thread pool, it should be shutdown
threadPool.shutdown();