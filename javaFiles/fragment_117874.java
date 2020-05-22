class StateMachine2 {
    State currentState;

    final StateEventListener stateEventPublisher = buildStateEventForwarder(); 

    StateEventListener buildStateEventForwarder() {
        Class<?>[] interfaces = {StateEventListener.class};
        return (StateEventListener) Proxy.newProxyInstance(getClass().getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    return method.invoke(currentState, args);
                } catch (InvocationTargetException e) {
                    throw e.getCause();
                }
            }
        });
    }
}