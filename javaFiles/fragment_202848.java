Class MyClass {
    private static final Object lock = new Object();

    public void invokeRequest() {
        synchronized (lock) {
            invokeRequestB();
        }
    }
    ...
}