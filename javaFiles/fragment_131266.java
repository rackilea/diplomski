@Before("methods()")
public Object checkSecurity(ProceedingJoinPoint pjp) throws Throwable{
    if (/*user is authenticated*/) {
        return pjp.proceed();
    } else {
        return "NOT OK";
    }
}