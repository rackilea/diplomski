/**
 * This scope works in conjunction with the {@link AsyncAspect} that goes to
 * cleanup the threadScoped beans after an async run. This is required since in
 * spring the async methods run in a pool of thread, so they could share some
 * thread scoped beans.
 * 
 * 
 * @author enrico.agnoli
 */
public class ThreadScope implements Scope {

    /**
     * This map contains for each bean name or ID the created object. The
     * objects are created with a spring object factory. The map is ThreadLocal,
     * so the bean are defined only in the current thread!
     */
    private final ThreadLocal<Map<String, Object>> threadLocalObjectMap = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        };
    };

    /** {@inheritDoc} */
    public Object get(final String beanName,
            final ObjectFactory<?> theObjectFactory) {
        Object object = threadLocalObjectMap.get().get(beanName);
        if (null == object) {
            object = theObjectFactory.getObject();
            threadLocalObjectMap.get().put(beanName, object);
        }
        return object;
    }

    /** {@inheritDoc} */
    public String getConversationId() {
        // In this case, it returns the thread name.
        return Thread.currentThread().getName();
    }

    /** {@inheritDoc} */
    public void registerDestructionCallback(final String beanName,
            final Runnable theCallback) {
        // nothing to do ... this is optional and not required
    }

    /** {@inheritDoc} */
    public Object remove(final String beanName) {
        return threadLocalObjectMap.get().remove(beanName);
    }

    @Override
    public Object resolveContextualObject(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Invoke this method to cleanUp the ThreadLocal beans. This call is
     * required since in case of run in a thread pool, the thread will never be
     * removed and the threadLocal variables would be shared between two
     * different executions!
     */
    public void cleanUpThreadScopedBeans() {
        threadLocalObjectMap.remove();
    }
}