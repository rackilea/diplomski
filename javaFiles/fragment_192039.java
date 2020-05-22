private ScheduledFuture<?> future;
public void start() {
    future = scheduledThreadPool.schedule(logicalWorker, delay, TimeUnit.SECONDS);
}
public void stop() {
    if(future != null) future.cancel();
}