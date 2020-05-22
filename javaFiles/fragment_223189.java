package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BoundFirstParameterAspect {
    @Pointcut("execution(* do*(..))")
    public static void myPointcut() {}

    @Around("myPointcut() && args()")
    public Object myAdvice(ProceedingJoinPoint thisJoinPoint) {
        return myAdviceWithParams(thisJoinPoint, null);
    }

    @Around("myPointcut() && args(request, ..)")
    public Object myAdviceWithParams(ProceedingJoinPoint thisJoinPoint, Object request) {
        System.out.println(">>> matching advice on " + thisJoinPoint);
        System.out.println("First parameter = " + request);
        Object result = thisJoinPoint.proceed();
        System.out.println("<<< matching advice on " + thisJoinPoint);
        return result;
    }
}