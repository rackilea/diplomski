@ClassRule // the magic is done here
public static TestRule classWatchman = new TestWatcher() {
    @Override
    protected void starting(Description desc) {
        System.out.println(desc.testCount()); // insert actual logic here
    }
};