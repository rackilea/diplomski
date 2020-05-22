static class SleepingCallable implements Callable<String> {

  final String name;
  final long period;

  SleepingCallable(final String name, final long period) {
    this.name = name;
    this.period = period;
  }

  public String call() {
    try {
      Thread.sleep(period);
    } catch (InterruptedException ex) { }
    return name;
  }
}