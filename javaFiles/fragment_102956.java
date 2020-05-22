void a() {
    synchronized (foo) {
        b();
    }
}

void b() {
    synchronized(foo) {
        // In here, the count is 2
    }
    // Now the count is still 1...
}