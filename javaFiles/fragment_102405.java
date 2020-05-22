public class ExceptionHandlingScheduledExecutor extends ScheduledThreadPoolExecutor {
    private final Thread.UncaughtExceptionHandler ueh;

    public ExceptionHandlingScheduledExecutor(int corePoolSize, Thread.UncaughtExceptionHandler ueh) {
        super(corePoolSize);
        this.ueh = ueh;
    }

    @Override
    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
        return super.schedule(wrap(command), delay, unit);
    }

    @Override
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
        return super.schedule(wrap(callable), delay, unit); 
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        return super.scheduleAtFixedRate(wrap(command), initialDelay, period, unit);
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        return super.scheduleWithFixedDelay(wrap(command), initialDelay, delay, unit);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task));
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return super.submit(wrap(task), result);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return super.submit(wrap(task));
    }

    private Runnable wrap(final Runnable runnable) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                } catch (final Throwable t) {
                    ueh.uncaughtException(Thread.currentThread(), t);
                    throw t;
                }
            }
        };
    }

    private <T> Callable<T> wrap(final Callable<T> callable) {
        return new Callable<T>() {
            @Override
            public T call() throws Exception {
                try {
                    return callable.call();
                } catch (Throwable t) {
                    ueh.uncaughtException(Thread.currentThread(), t);
                    throw t;
                }
            }
        };
    }
}