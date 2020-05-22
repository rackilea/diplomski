import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.atomic.AtomicInteger;

public class SoftAssertDemo implements IDataSet {
  private int size;
  private SoftAssert assertion = new SoftAssert();
  private AtomicInteger counter = new AtomicInteger(1);

  @Override
  public void setSize(int size) {
    this.size = size;
  }

  @Test(dataProvider = "dp")
  public void testMethod(int number) {
    if ((number % 2) == 0) {
      assertion.fail("Simulating a failure for " + number);
    }
    if (counter.getAndIncrement() == size) {
      assertion.assertAll();
    }
  }

  @DataProvider(name = "dp")
  public Object[][] getData(@TestInstance Object object) {
    Object[][] data = new Object[][] {{1}, {2}, {3}, {4}, {5}};
    if (object instanceof IDataSet) {
      ((IDataSet) object).setSize(data.length);
    }
    return data;
  }
}