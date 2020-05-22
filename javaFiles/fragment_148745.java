public class ResultsListener implements ISuiteListener, IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

        Object currentClass=testResult.getInstance();
        WebDriver driver = ((AppiumSetUp) currentClass).getDriver();
        System.out.println("Driver details:  " + driver);
     }
}