public final int addAndGet(int delta) {
    int current, next;
    do {
        current = get();
        next = current + delta;
    } while (!compareAndSet(current, next));
    return next;
}