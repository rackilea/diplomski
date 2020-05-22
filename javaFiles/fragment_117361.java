private static final long ONE_WEEK_IN_MILLIS = 604800000L;

public void foo(Date date) {
    if (date.getTiem() > System.currentTimeMillis() + 604800000L) {
        // No idea what to do here?
    }
}