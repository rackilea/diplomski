new ThreadPoolExecutor(
   1, 1, // single thread
   30, TimeUnit.SECONDS, // timeout, see javadoc
   new LinkedBlockingQueue(1), // queue with capacity 1 
   new ThreadPoolExecutor.DiscardOldestPolicy() // ditch the queued task when a new one comes in
);