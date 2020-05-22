class B {
  final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

  public boolean execute() {
    try {
      scheduler.scheduleWithFixedDelay(new BRunnnableTask(), period, delay);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public void close() {
    scheduler.shutdownNow();
  }
}