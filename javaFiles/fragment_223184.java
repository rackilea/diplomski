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
        return anotherMatchingAdvice(thisJoinPoint, null);
    }

    @Around("myPointcut() && args(request, ..)")
    public Object anotherMatchingAdvice(ProceedingJoinPoint thisJoinPoint, Object request) {
        System.out.println(">>> another matching advice on " + thisJoinPoint);
        Object result = thisJoinPoint.proceed();
        System.out.println("<<< another matching advice on " + thisJoinPoint);
        return result;
    }
}