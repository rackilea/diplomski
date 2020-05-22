package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyBetterAspect {
    @Around("execution(* doSomething(..))")
    public Object matchingAdvice(ProceedingJoinPoint thisJoinPoint) {
        System.out.println(">>> matching advice on " + thisJoinPoint);
        Object result = thisJoinPoint.proceed();
        System.out.println("<<< matching advice on " + thisJoinPoint);
        return result;
    }

    @Around("execution(* doSomething(..))")
    public Object anotherMatchingAdvice(ProceedingJoinPoint thisJoinPoint) {
        System.out.println(">>> another matching advice on " + thisJoinPoint);
        Object result = thisJoinPoint.proceed();
        System.out.println("<<< another matching advice on " + thisJoinPoint);
        return result;
    }
}