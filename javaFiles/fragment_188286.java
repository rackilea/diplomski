public class KeepAliveTimer {
  final Timer timer = new Timer();
  final long macAddress;
  final String ip;
  volatile TimerTask timerTask;

  public KeepAliveTimer(long mac, String ipAddress) {
    this.macAddress = mac;
    this.ip = ipAddress;
  }
  public void update() {
    if (timerTask != null) timerTask.cancel();
    timer.schedule(timerTask(), 10 * 60 * 1000);
  }
  private TimerTask timerTask() {
    return timerTask = new TimerTask() {
      @Override public void run() { timerFinished(); }
    };
  }
  public void timerFinished() {
    // tasks
  }
}