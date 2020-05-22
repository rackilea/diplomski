public class MyRetry implements IRetryAnalyzer {

@Override
public boolean retry(ITestResult result) {
    if (driver.getCurrentUrl() == "loginPageUrl") {
        //call login function or do whatever you need to to login 
        return true;
    }
    return false;
  }
}