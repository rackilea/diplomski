public class Foo {
    private final Object instanceLock = new Object();

    public void doSomething() {
        synchronized (instanceLock) {
            // Stuff
        }
    }
}

public class Bar {
    private static final Object staticLock = new Object();

    public static void doSomething() {
        synchronized (staticLock) {
            // Stuff
        }
    }
}