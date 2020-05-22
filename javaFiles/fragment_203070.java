private static final AtomicLong TIME_STAMP = new AtomicLong();
// can have up to 1000000 ids per second.
public static long getUniqueMicros() {
    long now = System.currentTimeMillis() * 1000;
    while (true) {
        long last = TIME_STAMP.get();
        if (now <= last)
            now = last + 1;
        if (TIME_STAMP.compareAndSet(last, now))
            return now;
    }
}