SomeService service = CreateService().andOpenTransaction();
ErrorHandlingCloseable.execute(new ErrorHandlingCloseable() {
    public void run() throws Exception { service.doSomeMessyThingsInsideDB(); }
    public void onError(Exception e) { service.rollbackTransaction(); }
    public void close() throws Exception { service.closeConnection(); }
});