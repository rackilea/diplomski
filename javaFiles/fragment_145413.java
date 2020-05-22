package threadLocal;

public class ThreadLocalManager {
    public static final ThreadLocal<String> accountUsername = new ThreadLocal<String>();
    public static final ThreadLocal<String> accountPassword = new ThreadLocal<String>();
    public static final ThreadLocal<Long> accountId = new ThreadLocal<Long>();
}