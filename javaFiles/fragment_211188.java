class MyClass {
    private final ReentrantLock lock = new ReentrantLock();
    public boolean theMethod() {
        if(!lock.tryLock()) {
            return false;
        }
        try {
            doStuff();
        } finally {
            lock.unlock(); 
        }
        return true;
    }
}