public static e(@NonNull String message) {

    RuntimeException e = new RuntimeException(message);
    StackTraceElement[] s = Arrays.copyOfRange(e.getStackTrace(), 1, s.length);
    e.setStackTrace(s);
    Crashlytics.logException(e);
}