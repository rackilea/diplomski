public class OperationHandler implements Runnable {
     public void run() {
        // no looping or dequeuing needed
        // just execute the job
     }
 }

 // create a thread pool with a single thread worker
 ExecutorService threadPool = Executors.newSingleThreadExecutor();
 // or create a thread pool with 10 workers
 // ExecutorService threadPool = Executors.newFixedThreadPool(10);
 // or you can create an open-ended thread pool
 // ExecutorService threadPool = Executors.newCachedThreadPool();
 ...
 // do this once or many times
 threadPool.submit(new OperationHandler());
 ...