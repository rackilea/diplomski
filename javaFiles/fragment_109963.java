public class Foo {
    private final Object lock = new Object();
    public void foo() {
        synchronized (lock) {
            // ...
        }
    }
}