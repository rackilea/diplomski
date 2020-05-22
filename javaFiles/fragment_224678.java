private final static Object lock = new Object();

public void myResource() {
    synchronized (lock) {
        // begin tx, do work, end tx.
        // Other callee won't get here before first callee is finished
    }
}