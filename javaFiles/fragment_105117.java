public class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {

    private final Thread.UncaughtExceptionHandler defaultUEH;

    public CustomExceptionHandler(Thread.UncaughtExceptionHandler defaultUEH) {
            this.defaultUEH = defaultUEH;
    }
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        String stackTrace = Log.getStackTraceString(ex);
        String time = new Date(System.currentTimeMillis()).toString();
        String message = ex.getMessage();

        // send logs...

        defaultUEH.uncaughtException(thread, ex);
    }
}