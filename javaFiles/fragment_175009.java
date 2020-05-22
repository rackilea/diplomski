package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MethodInterceptor {
    @Before("execution(!static * *(..))")
    public void interceptMethod(JoinPoint thisJoinPoint) {
        System.out.println(thisJoinPoint);
    }
}