@Around("execution(* save(..)) && target(serviceInterface)")
public Object pointCut(ProceedingJoinPoint thisJoinPoint, ServiceInterface serviceInterface)
    throws Throwable
{
    System.out.println(thisJoinPoint);
    return thisJoinPoint.proceed();
}