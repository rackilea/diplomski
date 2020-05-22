public class TestExecutionListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        System.out.println("Testing : " + iInvokedMethod.getTestMethod().getMethodName());
        System.out.println("Successfully Tested : " + iInvokedMethod.getTestMethod().getMethodName());
    }
}