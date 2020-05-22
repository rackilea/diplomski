private static class BatchInvocationHandler implements InvocationHandler {

    private final ExternalClass ext;

    private Queue<Callable<Object>> delayedInvocations = new ConcurrentLinkedQueue<Callable<Object>>();

    public BatchInvocationHandler(ExternalClass ext) {
        this.ext = ext;
    }

    @Override
    public Object invoke(Object proxy, final Method method, final Object[] args) throws Throwable {
        delayedInvocations.add(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return MethodUtils.invokeMethod(ext, method.getName(), args);
            }
        });
        return null;
    }

}