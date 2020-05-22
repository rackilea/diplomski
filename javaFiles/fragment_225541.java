package de.fhb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ReturnTypeChecker {
    @AfterReturning("within(de.fhb..*) && execution(java.util.List+ *(..)) && !execution(java.util.List *(..))")
    public void logServiceAccess(JoinPoint thisJoinPoint) {
        System.out.println(thisJoinPoint);
    }
}