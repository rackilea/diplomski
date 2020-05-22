public Object logProcess(ProceedingJoinPoint joinPoint) throws Throwable

    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = signature.getMethod();
    if(method.getName().equals("methodA")) {

    }
    //etc..