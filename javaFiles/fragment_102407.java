final ScheduledThreadPoolExecutor exec = new MyScheduledExecutor(1, new Thread.UncaughtExceptionHandler() {
      @Override
      public void uncaughtException(final Thread t, final Throwable e) {
        e.printStackTrace();
      }
    });