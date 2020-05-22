@Around("debug_log()")
public Object debug(ProceedingJoinPoint joinPoint) throws Throwable{
    LogUtil.debug("enter "+joinPoint.getSignature());
    try{
        // return the invocation
        return joinPoint.proceed();
    }
    catch(Throwable t){
        LogUtil.debug(t.getMessage()+"occurs in "+joinPoint.getSignature(),t);
        throw t;
    }
}