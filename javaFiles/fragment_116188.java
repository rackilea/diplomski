private static final long BCL_MILLISECONDS_AT_UNIX_EPOCH = 62135596800000L;
private static final long TICKS_PER_MILLISECOND = 10000L;
...

long bclMillis = System.currentTimeMillis() + BCL_MILLISECONDS_AT_UNIX_EPOCH;
long bclTicks = TICKS_PER_MILLISECOND * bclMillis;