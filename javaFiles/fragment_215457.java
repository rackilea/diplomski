public static long timeMethod(Method m, Object obj, Object... args) {
    long start = 0, stop = 0;
    try {
        start = SystemClock.uptimeMillis();
        m.invoke(obj, args);
        stop = SystemClock.uptimeMillis();
    } catch (Exception e) {
        return ERROR;
    }
    return stop - start;
}