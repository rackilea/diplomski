public final class LogUtils {
    private static final Logger logger = Logger.getLogger("name");

    private LogUtils() {
        // blocks the possibility to create a new instance
    }

    public static void log(Throwable e) {
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        String className = ste[2].getClassName();
        String methodName = ste[2].getMethodName();
        logger.log(Level.FINEST, String.format("%s#%s", className, methodName), e);
    }
}