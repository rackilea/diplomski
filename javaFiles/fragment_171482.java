@Before("within(pkg1..*)")
public Object  something(ProceedingJoinPoint joinPoint) throws Throwable { 
{
    if(false){
        throw SomeException; // returns with exception; make sure to catch this
    } else {
        joinPoint.proceed(); // Proceeds to execute the method
    }

    joinPoint.proceed();
}