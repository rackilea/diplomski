class ReflectiveMethodCallable implements Callable<Object> {
    private Object target;
    private Method method;
    private Object[] args;

    public ReflectiveMethodCallable(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    @Override
    public Object call() throws Exception {
        return method.invoke(target, args);
    }
}