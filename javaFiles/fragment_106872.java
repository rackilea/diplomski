@Around("execution(org.foo.Response com.mytest.example.*Resource.*(..))")
public Response restCallMade(ProceedingJoinPoint pjp) {
    Response response = null;
    try {
        response = (Response) pjp.proceed();
        // Do other stuff
    } catch (Throwable t) {}
    return response;
}