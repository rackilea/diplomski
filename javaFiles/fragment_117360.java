private static final long ONE_WEEK_IN_MILLIS = 7 * 24 * 60 * 60 * 1000L;

public void foo(Date date) {
    if (date.getTiem() > System.currentTimeMillis() + ONE_WEEK_IN_MILLIS) {
        // No idea what to do here?
    }
}