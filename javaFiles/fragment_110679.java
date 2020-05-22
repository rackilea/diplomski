public class YourComponent {
  protected int getRequestTimeframeMilliseconds() {
    return 600000;
  }
}

public class YourComponentTest {
  private static class YourComponentForTesting extends YourComponent {
    @Override protected int getRequestTimeframeMilliseconds() {
      return 500;
    }
  }

  @Test public void shouldTimeout() { /* ... */ }
}