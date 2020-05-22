final Object myObject = /*initialize the proxy target*/;
final Object proxy = Proxy.newProxyInstance(
    classLoader,
    new Class[] { /*your interface(s)*/ }, 
    new InvocationTargetHandler() {
        public Object invoke(Object proxy, Method method, Object[] args) {
            return method.invoke(myObject, args);
        }
});