private static final AtomicLong TIME_STAMP = new AtomicLong();
// can have up to 1000 ids per second.
public static long getUniqueMillis() {
    long now = System.currentTimeMillis();
    while (true) {
        long last = TIME_STAMP.get();
        if (now <= last)
            now = last + 1;
        if (TIME_STAMP.compareAndSet(last, now))
            return now;
    }
}