public class TimeoutProcessKiller extends TimerTask {
  private Process p;
  public TimeoutProcessKiller(Process p) {
    this.p = p;
  }

  public void run() {
    p.destroy();
  }
}