public class MyClass {

    private final Object lock = new Object();

    public void reconnect() {
        synchronized(lock) {
            ....
        }
    }

    ....
}