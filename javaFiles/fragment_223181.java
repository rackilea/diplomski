package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyBogusAspect {
    @Around("execution(* doSomething(..))")
    public Object matchingAdvice(ProceedingJoinPoint thisJoinPoint) {
        System.out.println("matching advice called on joinpoint " + thisJoinPoint);
        return nonMatchingAdvice(thisJoinPoint);
    }

    @Around("execution(* doSomethingElse(..))")
    public Object nonMatchingAdvice(ProceedingJoinPoint thisJoinPoint) {
        System.out.println("non-matching advice called on joinpoint " + thisJoinPoint);
        return thisJoinPoint.proceed();
    }
}