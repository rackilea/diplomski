Future<?> future = Executors.newSingleThreadExecutor().submit(new Runnable() {
    public void run() {
        methodUnderTest();
    } 
});
try {
    future.get(5, TimeUnit.SECONDS);
    fail("The task has completed before 5 seconds");
}
catch (TimeoutException e) {
    // expected
}