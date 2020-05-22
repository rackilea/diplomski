contextManager.registerTestExecutionListeners(new AbstractTestExecutionListener() {
    @Override
    public void prepareTestInstance(TestContext freshTestContext) throws Exception {
        testContext = freshTestContext;
    }
});