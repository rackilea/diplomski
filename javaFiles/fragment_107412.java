class MyInvocationHandler implements InvocationHandler {
    private Object target;
    private ExecutorService executorService;

    public MyInvocationHandler(Object target, ExecutorService executorService) {
        this.target = target;
        this.executorService = executorService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            Callable<Object> task = new ReflectiveMethodCallable(target, method, args);
            Future<Object> future = executorService.submit(task);
            return future.get();
        }
        catch(ExecutionException e1){
            try {
                throw e1.getCause();
            } catch(InvocationTargetException e2){
                throw e2.getCause();
            }
        }
    }
}