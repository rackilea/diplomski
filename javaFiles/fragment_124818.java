import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TestClassSample implements IHookable {

  @Test
  public void testMethod1() {
    System.err.println("testMethod1");
  }

  @Test
  public void failMe() {
    System.err.println("failMe");
  }

  @Override
  public void run(IHookCallBack callBack, ITestResult result) {
    callBack.runTestMethod(result);
    if (result.getMethod().getMethodName().equalsIgnoreCase("failme")) {
      result.setStatus(ITestResult.FAILURE);
      result.setThrowable(new RuntimeException("Simulating a failure"));
    }
  }
}