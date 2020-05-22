package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AdviceInterceptor {
    @Before("!within(AdviceInterceptor) && adviceexecution()")
    public void interceptAdvice(JoinPoint thisJoinPoint) {
        System.out.println(thisJoinPoint);
    }
}