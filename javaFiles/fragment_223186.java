package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BoundFirstParameterAspect {
    @Pointcut("execution(* do*(..))")
    public static void myPointcut() {}

    @Around("myPointcut()")
    public Object matchingAdvice(ProceedingJoinPoint thisJoinPoint) {
        System.out.println(">>> matching advice on " + thisJoinPoint);
        Object[] args = thisJoinPoint.getArgs();
        Object request =  args.length > 0 ? args[0] : null;
        System.out.println("First parameter = " + request);
        Object result = thisJoinPoint.proceed();
        System.out.println("<<< matching advice on " + thisJoinPoint);
        return result;
    }
}