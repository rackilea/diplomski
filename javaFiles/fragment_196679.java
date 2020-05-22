try {
    synchronized (lock) {
        // we will wait here until we get notified
        lock.wait();
    }
} catch (InterruptedException e) {
    e.printStackTrace();
}