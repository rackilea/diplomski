Object newProxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{interfaceSupplier}, new InvocationHandler() {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //TODO check method
        return fatalSupplier.get();
    }
});
methodFatal.invoke(logger, newProxyInstance);