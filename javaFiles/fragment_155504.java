private int i;
private final Object lock = new Object();

void foobar(...) {
    ...
    synchronized(lock) {
        i = ...;
    }
}

int getI() {
    synchronized(lock) {
        return i;
    }
}