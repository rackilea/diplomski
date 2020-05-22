@AroundInvoke
public Object intercept(InvocationContext context) throws Exception {
    return monitor(context);
}

@AroundTimeout
public Object interceptSchedule(InvocationContext context) throws Exception {
    return monitor(context);
}

private Object monitor(InvocationContext context) throws Exception {
    long millis = System.currentTimeMillis();

    String method = context.getMethod().getName();
    String className = context.getTarget().getClass().getSimpleName();

    Object object = context.proceed();

    long newMillis = System.currentTimeMillis() - millis;
    System.out.println("[LOG]-" + method + "." + className + "-" + newMillis + "ms");
    return object;
}