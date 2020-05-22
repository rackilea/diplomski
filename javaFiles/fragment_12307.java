import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class FailedTestCapturer {

  @SuppressWarnings("null")
  private static int throwNPE() {
    String x = null;
    return x.length();
  }

  private String exception;
  @Rule
  public final TestRule watchman = new TestWatcher() {
    @Override
    protected void failed(Throwable e, Description description) {
      StringWriter writer = new StringWriter();
      e.printStackTrace(new PrintWriter(writer));
      exception = writer.toString();
      System.out.println("Captured exception! --> " + exception);
    }
  };

  @Test
  public void failingTest() {
    throwNPE();
  }
}