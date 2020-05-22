public class MethodListener implements IInvokedMethodListener2 {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

        List<String> failed = context
                        .getFailedTests()
                        .getAllMethods()
                        .stream()
                        .map(ITestNGMethod::getMethodName)
                        .collect(Collectors.toList());

        boolean isSkippable = false;
        if (failed.size() > 0 && method.getTestMethod().getDescription() != null) {
            List<String> methodNames = Arrays.asList(method.getTestMethod().getDescription().split(";"));
            isSkippable = failed
                            .stream()
                            .anyMatch(methodNames::contains);
        }


        if (isSkippable) {
            throw new SkipException("Skipping " + method.getTestMethod().getMethodName());
        }

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }
}