@Around("execution (* *(fully.qualified.name.CloudFile)) && args(cloudFile)")
public Object captureFileAttribute(ProceedingJoinPoint joinPoint, CloudFile cloudFile) throws Throwable {
        Object result = joinPoint.proceed();
        System.err.println(cloudFile);
        return result;
    }