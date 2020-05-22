import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Utilities to support using dynamic proxies
 */
public class DynamicProxy {

    /**
     * An invocation handler that passes calls to its delegate. This class
     * could be subclassed to provide dynamic method invocation handling
     * while still being able to fall back to the delegate object's methods.
     *
     * @see InvocationHandler
     */
    public static class DelegatingInvocationHandler
    implements InvocationHandler {

        /** The object this proxy is wrapping */
        private final Object delegate;

        /**
         * Creates a delegate invocation handler around an object
         *
         * @param object
         *            The object to wrap
         */
        public DelegatingInvocationHandler(final Object delegate) {
            this.delegate = delegate;
        }

        /* (non-Javadoc)
         *
         * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
         * java.lang.reflect.Method, java.lang.Object[])
         */
        @Override
        public Object invoke(final Object proxy, final Method m,
                final Object[] args) throws Throwable {
            Object result;

            try {
                result = m.invoke(delegate, args);
            } catch (final InvocationTargetException e) {
                throw e.getTargetException();
            } catch (final Exception e) {
                throw new RuntimeException("unexpected invocation exception: "
                        + e.getMessage());
            }

            return result;
        }
    }

    /**
     * Create a dynamic proxy that implements only a specified subset of the
     * original object's implemented interfaces. The proxy allows you to
     * essentially hide the other interfaces implemented by the original
     * object.
     *
     * @param delegate
     *            the object that the proxy "proxies" for (a.k.a. the delegate
     *            that handles the calls the proxy "allows" through)
     * @param requiredInterface
     *            one of the interfaces of the delegate that the proxy exposes
     * @param moreInterfaces
     *            any additional interfaces of the delegate to expose
     * @return the proxy
     *             a proxy for the delegate that can be cast to any of the
     *             specified interfaces
     */
    public static <T> T createSelectiveProxy(final T delegate,
            final Class<T> requiredInterface,
            final Class<?>... moreInterfaces) {
        if (delegate == null) {
            throw new IllegalArgumentException(
                    "The delegate object cannot be null");
        }

        return createProxy(new DelegatingInvocationHandler(delegate),
                requiredInterface, moreInterfaces);
    }

    /**
     * Creates a proxy using the specified invocation handler.
     *
     * @param object
     *            the implementing object that proxy wraps
     * @param invocationHandler
     *            the interfaces
     * @param moreInterfaces
     *            the interfaces
     * @return the object
     */
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(final InvocationHandler invocationHandler,
            final Class<T> requiredInterface,
            final Class<?>... moreInterfaces) {
        if (invocationHandler == null) {
            throw new IllegalArgumentException(
                    "The invocation handler cannot be null");
        }

        final int size = (moreInterfaces != null ? moreInterfaces.length : 0);
        final Class<?>[] interfaces = new Class<?>[size + 1];
        interfaces[0] = requiredInterface;
        System.arraycopy(moreInterfaces, 0, interfaces, 1, moreInterfaces.length);

        return (T) Proxy.newProxyInstance(invocationHandler.getClass()
                .getClassLoader(), interfaces, invocationHandler);
    }
}