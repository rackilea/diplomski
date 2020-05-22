public class DelegatingHandler implements InvocationHandler {
    private final List<Object> factoryDelegates;

    public DelegatingHandler(Object ... factories) {
        factoryDelegates = Arrays.asList(factories);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (Object factory : factoryDelegates) {
            Method[] declaredMethods = factory.getClass().getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                if (declaredMethod.getReturnType().equals(method.getReturnType())) {
                    return method.invoke(factory, args);
                }
            }
        };
        return null;
    }
}