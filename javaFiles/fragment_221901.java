public class RequestContext {

private static ThreadLocal<Map<Object, Object>> attributes = new ThreadLocal<>();

public static void initialize() {
    attributes.set(new HashMap());
}

public static void cleanup() {
    attributes.set(null);
}

public static <T> T getAttribute(Object key) {
    return (T) attributes.get().get(key);
}

public static void setAttribute(Object key, Object value) {
    attributes.get().put(key, value);
}