public class TimerDemo {

  public static void main(String[] args) {
    // non-daemon threads prevent termination of VM
    final boolean isDaemon = false;
    Timer timer = new Timer(isDaemon);

    final long threeSeconds = 3 * 1000;
    final long delay = 0;
    timer.schedule(new HelloTask(), delay, threeSeconds);

    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MINUTE, 1);
    Date oneMinuteFromNow = calendar.getTime();

    timer.schedule(new KillTask(timer), oneMinuteFromNow);
  }

  static class HelloTask extends TimerTask {
    @Override
    public void run() {
      System.out.println("Hello");
    }
  }

  static class KillTask extends TimerTask {

    private final Timer timer;

    public KillTask(Timer timer) {
      this.timer = timer;
    }

    @Override
    public void run() {
      System.out.println("Cancelling timer");
      timer.cancel();
    }
  }

}