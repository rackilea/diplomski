package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {
    @AfterThrowing(value = "execution(* *(..))", throwing = "e")
    public void log(JoinPoint thisJoinPoint, Throwable e) {
        System.out.println(thisJoinPoint + " -> " + e);
    }

    @Before("handler(*) && args(e)")
    public void logCaughtException(JoinPoint thisJoinPoint, Exception e) {
        System.out.println(thisJoinPoint + " -> " + e);
    }
}