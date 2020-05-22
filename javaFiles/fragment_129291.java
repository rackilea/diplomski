private final Object LOCK = new Object();

// Later:
synchronized (LOCK) {
    // LOCK is not known to any "outsiders", safe to use it as internal lock
}