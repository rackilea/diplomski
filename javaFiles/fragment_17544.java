@BeforeSuite(alwaysRun = true)
public void beforeSuite(ITestContext context) {
     TestRepeat testRepeat = new TestRepeat();
     for (ITestNGMethod method : context.getAllTestMethods()) {
         method.setRetryAnalyzer(testRepeat);
     }
}