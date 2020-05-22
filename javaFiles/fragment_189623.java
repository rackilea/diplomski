@Rule public TestName name = new TestName();
@Before
public void testNonFailedOnly() {
    Assume.assumeTrue(!failedTests.contains(name.getMethodName()));
}
private static List<String> failedTests = new ArrayList<String>(256);

@Rule
public TestWatcher watchman = new TestWatcher() {
    /* (non-Javadoc)
     * @see org.junit.rules.TestWatcher#failed(java.lang.Throwable, org.junit.runner.Description)
     */
    @Override
    protected void failed(Throwable e, Description description) {
        super.failed(e, description);
        failedTests.add(description.getMethodName());
    }
};