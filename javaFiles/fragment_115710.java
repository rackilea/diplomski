class Foo {
    private final Object LOCK = new Object();
    public void doSomething() {
        synchronized (LOCK) {
            // Whatever
        }
    }
}