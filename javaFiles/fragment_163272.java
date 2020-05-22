import java.util.logging.*;

public class ForLoop {
    private static Logger logger = Logger.getLogger("log");

    public static void a(Throwable e) {
        StackTraceElement elements[] = e.getStackTrace();
        for (int i = 0, n = elements.length; i < n; i++) {
            logger.log(Level.WARNING, elements[i].getMethodName());
        }
    }

    public static void b(Throwable e) {
        StackTraceElement elements[] = e.getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            logger.log(Level.WARNING, elements[i].getMethodName());
        }
    }

    public static void c(Throwable e) {
        StackTraceElement elements[] = e.getStackTrace();
        int n = elements.length;
        for (int i = 0; i < n; i++) {
            logger.log(Level.WARNING, elements[i].getMethodName());
        }
    }
}