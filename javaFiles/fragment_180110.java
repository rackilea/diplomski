private static final Object lockObj = new Object();

private void waitForThread() {
    synchronized(lockObj) {...}
}

private void finished() {
    synchronized(lockObj) {...}
}