public class Service {
    private volatile long lastActivity;
    public void do(Foo foo) {
        // process foo
        lastActivity = System.currentTimeMillis();
    }

    private void onIdle() {
        if (lastActivity > 0 && System.currentTimeMillis() - lastActivity > 5000) {
            // do stuff
            lastActivity = 0;
        }
    }
}