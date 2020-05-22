public class GeneratedCodeLogger extends TestWatcher {
  private Logger log;

  public GeneratedCodeLogger(Logger log) {
    this.log = log;
  }

  @Override
  protected void failed(Description d) {
    System.out.println(log.toString());
  }
}