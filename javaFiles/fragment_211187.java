class MyClass {
    private final ReentrantLock lock = new ReentrantLock();
    public void theMethod() {
        if(!lock.tryLock()) {
            throw new IllegalStateException("Running already");
        }
        try {
            // do stuff
        } finally {
            lock.unlock(); 
        }
    }
}