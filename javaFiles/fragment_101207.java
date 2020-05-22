/**
     * A hacky way to determine whether the application is running normally,
     * or as part of an instrumentation test.
     */
    public static boolean isTestMode(Context context) {
        boolean result;
        try {
            context.getClassLoader().loadClass("com.TestsRunningFlag");
            result = true;
        } catch (final Exception e) {
            result = false;
        }
        return result;
    }