public class PrintTestName extends TestWatcher {
  @Override
  protected void starting(Description d) {
      System.out.println(d.getMethodName());
  }
}