package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class FieldAccessLogger {
    @Pointcut("get(* de.scrum_master.app.Application.*)")
    public void fieldAccess() {}

    @AfterReturning(pointcut = "fieldAccess()", returning = "field")
    public void afterFieldAccess(Object field, JoinPoint thisJoinPoint) {
        System.out.println(thisJoinPoint.toLongString());
        System.out.println("  " + thisJoinPoint.getSignature().getName());
        System.out.println("  " + field);
    }
}