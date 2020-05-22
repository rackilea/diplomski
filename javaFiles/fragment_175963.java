public abstract class LoggedTest extends TestCase {
  protected boolean displayLog;
  protected StringBuilder log;

  public void tick() {
    displayLog = true;
  }

  public void tack() {
    displayLog = false;
  }

  public void log(String msg) {
    log.append(message);
  }

  protected void setUp() {
    displayLog = false;
    log = new StringBuilder();
  }

  protected void tearDown() {
    if(displayLog) {
      System.err.println(log);
    }
  }
}