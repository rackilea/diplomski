@Test
public void aTest() {
    // run your test

    // this will wait until Karaf is available for at most 10 seconds
    // and will check every 100ms so if Karaf becomes available earlier 
    // than 10 seconds then the test will complete almost as soon as
    // it becomes available but if Karaf does not become available 
    // within 10 seconds then the test will fail
    await().atMost(10, SECONDS).until(karafIsAvailable());

    // assert 
    // ...
}

private Callable<Boolean> karafIsAvailable() {
    return new Callable<Boolean>() {
        public Boolean call() throws Exception {
            // return true if your condition has been met
            // e.g. assertBundleState
            return ...;
        }
    };
}