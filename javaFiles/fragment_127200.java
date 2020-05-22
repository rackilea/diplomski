public static int safeGetAndIncrement(AtomicInteger i) {
    int oldValue = 0;
    do {
        oldValue = i.get();
        int newValue = (oldValue == MAX_VALUE) ? 0 : (oldValue + 1);
    } while (!i.compareAndSet(oldValue, newValue));
    return oldValue;
}