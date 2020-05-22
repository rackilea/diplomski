threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
       // this will block if the queue is full
       executor.getQueue().put(r);
    }
});