private static synchronized boolean compareAndSet(boolean expected, boolean value) {
    if (occupied == expected) { // (1)
        occupied = value; // (2)
        return true;
    } else {
        return false;
    }
}