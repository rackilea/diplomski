class B {
  static final ScheduledExecutorService SCHEDULER = Executors.newCachedThreadPool();

  public boolean execute() {
    try {
      SCHEDULER.scheduleWithFixedDelay(new BRunnnableTask(), period, delay);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}