import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTestClass {

  private static final String KEY = "webdriver.deviceName.iPhone";

  @BeforeClass
  public void beforeClass(ITestContext context) {
    String value = context.getCurrentXmlTest().getParameter(KEY);
    System.err.println("webdriver.deviceName.iPhone = " + value);
  }

  @Test
  public void testMethod() {
    String value = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(KEY);
    System.err.println("webdriver.deviceName.iPhone = " + value);
  }
}