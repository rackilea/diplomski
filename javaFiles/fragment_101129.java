@Pointcut("execution(* setHeight(..))")
public void setters() {}

@Before("setters()") 
public void log(JoinPoint point) {
...
}