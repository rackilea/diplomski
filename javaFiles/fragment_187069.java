import java.util.concurrent.atomic.AtomicInteger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTestCase {

  private final AtomicInteger counter = new AtomicInteger(1);

  @Test(dataProvider = "getData")
  public void testMethod(String s) {
    if (counter.getAndIncrement() == 2) {
      System.err.println("Debug mode on"); //Set a breakpoint on this line
    }
    System.err.println("Hello " + s);

  }

  @DataProvider
  public Object[][] getData() {
    return new Object[][]{
        {"TestNG"},{"Spring"},{"Selenium"}
    };
  }

}