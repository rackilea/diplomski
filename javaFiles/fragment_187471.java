private static final long MIN_MS = 1000 * 60;
private static final long HOUR_MS = MIN_MS * 60;
private static final long DAY_MS = HOUR_MS * 24;
private static final long WEEK_MS = DAY_MS * 7;
private static final long QUARTER_MS = WEEK_MS * 12;

public static void main(String[] args) throws Exception {
    long msecs = 31535872360L;/*A few seconds short of a year*/
    long q = msecs / QUARTER_MS;
    msecs -= q * QUARTER_MS;
    long w = msecs / WEEK_MS;
    msecs -= w * WEEK_MS;
    long d = msecs / DAY_MS;
    msecs -= d * DAY_MS;
    long h = msecs / HOUR_MS;
    msecs -= h * HOUR_MS;
    long min = msecs / MIN_MS;
    msecs -= min * MIN_MS;
    long secs = msecs / 1000;
    System.out.printf("%d q,%d w, %d d, %d:%d:%d \n", q, w, d, h, min, secs);
}