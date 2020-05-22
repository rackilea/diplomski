while (!isCollided()) {
    synchronized (monitor) {
        // make all the modifications to the shared data (i.e. the field)
    }
    ...
    Thread.sleep(...);
}