import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogTimeAspect {
    @Pointcut("execution(public * *(..))")
    public void publicMethod() {}

    @Around("publicMethod() && @annotation(logAnn)")
    public Object LogExecutionTimeByMethod(ProceedingJoinPoint joinPoint, LogExecutionTime logAnn) throws Throwable {
        System.out.println(joinPoint + " -> " + logAnn.level());
        return joinPoint.proceed();
    }

    @Around("publicMethod() && @within(logAnn)")
    public Object LogExecutionTimeByClass(ProceedingJoinPoint joinPoint, LogExecutionTime logAnn) throws Throwable {
        System.out.println(joinPoint + " -> " + logAnn.level());
        return joinPoint.proceed();
    }
}