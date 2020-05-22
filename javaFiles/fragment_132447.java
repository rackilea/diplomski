@ClassRule
public static TestRule classWatchman = new TestWatcher() {
    @Override
    protected void finished(Description desc) {
        System.out.println("Suite completed!"); // insert actual logic here
    }
};