class MyClass {
    private final AtomicBoolean hasExecuted = new AtomicBoolean(false);
    public boolean theMethod() {
        if(!hasExecuted.compareAndSet(false, true) {
            return false; // or throw an exception
        }
        doStuff();
        return true;
    }
}