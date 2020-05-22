public class MyListener extends TransactionalTestExecutionListener {
    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
      super.afterTestMethod(testContext);
      ITestResult currentTestResult = getCorrespondingResultFor(testContext.getTestMethod());
    }

    private ITestResult getCorrespondingResultFor(Method method) {
      ITestContext context = Reporter.getCurrentTestResult().getTestContext();
      Set<ITestResult> allResults = new HashSet<>();
      allResults.addAll(context.getPassedTests().getAllResults());
      allResults.addAll(context.getFailedTests().getAllResults());
      allResults.addAll(context.getSkippedTests().getAllResults());
      return allResults
          .stream()
          .filter(result -> result.getMethod().getConstructorOrMethod().getMethod().equals(method))
          .findAny()
          .orElse(null);
    }
}