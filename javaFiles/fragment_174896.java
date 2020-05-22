class TestListener extends RunListener {
    @Override
    public void testRunStarted(Description description) throws Exception {
        // Called before any test has started
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        // Called when all tests have finished
    }

    @Override
    public void testStarted(Description description) throws Exception {
    }

    @Override
    public void testFinished(Description description) throws Exception {
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
    }

    @Override
    public void testAssumptionFailure(Failure failure) {
    }

    @Override
    public void testIgnored(Description description) throws Exception {
    }
}