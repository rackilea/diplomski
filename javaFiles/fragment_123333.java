public class AdapterFactory {

    public static <T> T createAdapter(Object target, Class<T> interfaceClass) {
        if (!interfaceClass.isInterface())
            throw new IllegalArgumentException("Must be an interface: " + interfaceClass.getName());
        return (T) Proxy.newProxyInstance(null, new Class<?>[] { interfaceClass }, new AdapterInvocationHandler(target));
    }
}