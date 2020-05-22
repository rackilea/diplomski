class MockService extends MyService() {
    private Async async;
    public MockService(Async async) {
        this.async = async;
    }
    @Override public void methodMayFail() {
        async.complete()
    }
}