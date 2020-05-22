@Override
public void onStart(ITestContext testContext) {
    super.onStart(testContext);
    ITestNGMethod[] methods = testContext.getAllTestMethods();
    // here we can save methods into some object
}