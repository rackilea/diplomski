public final float incrementAndGet() {
    for (;;) {
        float current = get();
        float next = current + 1;
        if (compareAndSet(current, next))
            return next;
    }
}