private String getTime() {
    long diff = System.nanoTime() - this.timestamp;
    TimePoint point = this.getTimePoint(diff);
    if (point.getNext() != null) {
        return String.format("%d %s, %d %s", point.getTime(), point.getUnit().toString(),
                point.getNext().getTime(), point.getNext().getUnit().toString());
    } else {
        return String.format("%d %s", point.getTime(), point.getUnit().toString());
    }
}

private static class TimePoint {

    private final long time;
    private final TimeUnit unit;
    private TimePoint next;

    public TimePoint(long time, TimeUnit unit, TimePoint next) {
        this.time = time;
        this.unit = unit;
        this.next = next;
    }

    public long getTime() {
        return this.time;
    }

    public TimeUnit getUnit() {
        return this.unit;
    }

    public TimePoint getNext() {
        return this.next;
    }

    public TimePoint setNext(TimePoint next) {
        this.next = next;
        return this;
    }
}

/**
 * Absolutely disgusting method of retrieving the largest non-zero times
 * difference in a nanosecond period. Forgive me for my sins
 *
 * @since 1.0.0
 * @version 1.0.0
 *
 * @param diff The difference in nanoseconds between two points
 * @return A new {@link TimePoint} representing the largest represented time
 */
private TimePoint getTimePoint(long diff) {
    if (diff < 0) {
        return null;
    }
    long temp;
    TimeUnit u = TimeUnit.NANOSECONDS;
    TimePoint root = null;
    if ((temp = u.toDays(diff)) > 0) {
        root = new TimePoint(temp, TimeUnit.DAYS, null);
        diff -= root.getUnit().toNanos(root.getTime());
    }
    if ((temp = u.toHours(diff)) > 0 || (root != null && temp >= 0)) {
        TimePoint p = new TimePoint(temp, TimeUnit.HOURS, null);
        root = this.allocateNodes(root, p);
        diff -= p.getUnit().toNanos(p.getTime());
    }
    if ((temp = u.toMinutes(diff)) > 0 || (root != null && temp >= 0)) {
        TimePoint p = new TimePoint(temp, TimeUnit.MINUTES, null);
        root = this.allocateNodes(root, p);
        diff -= p.getUnit().toNanos(p.getTime());
    }
    if ((temp = u.toSeconds(diff)) > 0 || (root != null && temp >= 0)) {
        TimePoint p = new TimePoint(temp, TimeUnit.SECONDS, null);
        root = this.allocateNodes(root, p);
        diff -= p.getUnit().toNanos(p.getTime());
    }
    if ((temp = u.toMillis(diff)) > 0 || (root != null && temp >= 0)) {
        TimePoint p = new TimePoint(temp, TimeUnit.MILLISECONDS, null);
        root = this.allocateNodes(root, p);
        diff -= p.getUnit().toNanos(p.getTime());
    }
    if ((temp = u.toMicros(diff)) > 0 || (root != null && temp >= 0)) {
        TimePoint p = new TimePoint(temp, TimeUnit.MICROSECONDS, null);
        root = this.allocateNodes(root, p);
        diff -= p.getUnit().toNanos(p.getTime());
    }
    if (diff >= 0 || (root != null && temp >= 0)) {
        TimePoint p = new TimePoint(temp, TimeUnit.NANOSECONDS, null);
        root = this.allocateNodes(root, p);
        diff -= p.getUnit().toNanos(p.getTime());
    }
    return root;
}

private TimePoint allocateNodes(TimePoint root, TimePoint allocate) {
    if (root == null) {
        return allocate;
    } else if (root.getNext() != null) {
        return root.setNext(this.allocateNodes(root.getNext(), allocate));
    } else {
        return root.setNext(allocate);
    }
}