public void doSomething() {
    logAndCleanup(new Callable<Void>() {
        public Void call() throws Exception {
            implementationOfDoSomething();
            return null;
        }
    });
}

private void logAndCleanup(Callable<Void> callable) {
    try {
        callable.call();
    } 
    catch (Exception e) {
        MyEnv.getLogger().log(e);
    } 
    finally {
        genericCleanUpMethod();
    }
}