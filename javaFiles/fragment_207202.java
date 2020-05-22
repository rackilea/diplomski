private Future<?> scheduleWithFixedDelayAndCallback(ScheduledExecutorService service, Runnable work, long initialDelay, long delay, TimeUnit unit, Runnable cleanup) {

    Object monitor = new Object();

    Runnable monitoredWork = new SynchronizedRunnable(monitor, work);

    Runnable monitoredCleanup = new SynchronizedRunnable(monitor, cleanup);

    Future<?> rawFuture = service.scheduleAtFixedRate(monitoredWork, initialDelay, delay, unit);

    Future<?> wrappedFuture = new FutureWithCancelCallback(rawFuture, monitoredCleanup);

    return wrappedFuture;
}