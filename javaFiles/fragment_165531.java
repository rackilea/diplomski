public interface ITestListener extends ITestNGListener {

  public void onTestStart(ITestResult result);

  public void onTestSuccess(ITestResult result);

  public void onTestFailure(ITestResult result);

  public void onTestSkipped(ITestResult result);

  public void onTestFailedButWithinSuccessPercentage(ITestResult result);

  public void onStart(ITestContext context);

  public void onFinish(ITestContext context);