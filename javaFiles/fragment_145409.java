package inheritableThreadLocal;

public class ThreadLocalManager {
    public static final InheritableThreadLocal<String> accountUsername = new InheritableThreadLocal<String>();
    public static final InheritableThreadLocal<String> accountPassword = new InheritableThreadLocal<String>();
    public static final InheritableThreadLocal<Long> accountId = new InheritableThreadLocal<Long>();
}