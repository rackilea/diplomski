@Aspect
public class Aspect1 {

    @Pointcut("execution(* *(..))")
    public void demoPointcut() {}

    @Around("demoPointcut()")
    public void demoAdvice(JoinPoint joinPoint) {}
}