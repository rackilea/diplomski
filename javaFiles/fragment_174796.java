public static <T> T makeImmutable(final T t) throws NotFoundException, InstantiationException, IllegalAccessException {
    MethodHandler mh = new MethodHandler() {
        @Override
        public Object invoke(java.lang.Object self, java.lang.reflect.Method thisMethod, java.lang.reflect.Method proceed, java.lang.Object[] args) throws Throwable {
            if (thisMethod.getName().startsWith("set")) {
                throw new UnsupportedOperationException();
            }
            return proceed.invoke(t, args);
        }

    };

    ProxyFactory proxyFactory = new ProxyFactory();
    proxyFactory.setSuperclass(t.getClass());
    Class<T> clazz = (Class<T>) proxyFactory.createClass();
    T instance = clazz.newInstance();
    ((ProxyObject)instance).setHandler(mh);

    return instance;

}