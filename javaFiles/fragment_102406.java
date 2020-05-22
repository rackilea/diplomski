class MyScheduledExecutor extends ScheduledThreadPoolExecutor {
  private final Thread.UncaughtExceptionHandler ueh;
  private final ExecutorService futureService = Executors.newCachedThreadPool();

  public MyScheduledExecutor(int corePoolSize, Thread.UncaughtExceptionHandler ueh) {
    super(corePoolSize);
    this.ueh = ueh;
  }

  // Copy other constructors

  @Override
  public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
                                                   long initialDelay,
                                                   long delay,
                                                   TimeUnit unit) {
    final ScheduledFuture<?> f = super.scheduleWithFixedDelay(command, initialDelay, delay, unit);
    futureService.submit(new Runnable() {
      @Override
      public void run() {
        try {
          f.get();
        } catch (Throwable t ) {
          ueh.uncaughtException(null, t.getCause());
        }
      }
    };

    return f;
  }

  // Do similarly for other submit/schedule methods
}