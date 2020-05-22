public class RequestScope {
    private static final ThreadLocal<String> id = ThreadLocal.withInitial(() -> UUID.randomUUID().toString());

    public static String get() {
        return id.get();
    }
}