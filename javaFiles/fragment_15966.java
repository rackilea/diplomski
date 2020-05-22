class MyMethodInteceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        Object[] args = invocation.getArguments();

        // do your logging or whatever with the args.

        // invoke method and get return value.
        Object returnValue = invocation.proceed();
        // if you want to do something with the return
        // value before returning it, you can.

        return returnValue;
    }
}