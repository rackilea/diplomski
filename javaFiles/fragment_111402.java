Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.err.printf("Thread %s threw an uncaught exception!%n", t.getName());
        e.printStackTrace();
    }
});