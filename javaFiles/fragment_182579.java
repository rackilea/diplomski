BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100);
// NOTE: you want the min and max thread numbers here to be the same value
ThreadPoolExecutor threadPool =
    new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, queue);
// we need our RejectedExecutionHandler to block if the queue is full
threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
       @Override
       public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
           try {
                // this will block the producer until there's room in the queue
                executor.getQueue().put(r);
           } catch (InterruptedException e) {
                throw new RejectedExecutionException(
                   "Unexpected InterruptedException", e);
           }
    }
});

// now read in the urls
while ((String url = urlReader.readLine()) != null) {
    // submit them to the thread-pool.  this may block.
    threadPool.submit(new DownloadUrlRunnable(url));
}
// after we submit we have to shutdown the pool
threadPool.shutdown();
// wait for them to complete
threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

...
private class DownloadUrlRunnable implements Runnable {
    private final String url;
    public DownloadUrlRunnable(String url) {
       this.url = url;
    }
    public void run() {
       // download the URL
    }
}