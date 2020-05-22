@Around("execution(* com.myproject..*(..))")
public Object log(ProceedingJoinPoint pjp) throws Throwable{

....
Object result = pjp.proceed();
......
return result;
}