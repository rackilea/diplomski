package de.scrum_master.aspect;

import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DemoAspect {
    private static ThreadLocal<UUID> id = new ThreadLocal<UUID>() {
        @Override
        protected UUID initialValue() {
            return UUID.randomUUID();
        }
    };

    @Pointcut("execution(* *(..)) && !within(DemoAspect)")
    public void logging() {}

    @Around("logging()")
    public Object tracing(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        Signature methodSignature = thisJoinPoint.getSignature();
        System.out.println(
            "Thread " + Thread.currentThread().getId() +
            "[" + id.get() +
            "] >>> " + methodSignature
        );
        Object result = thisJoinPoint.proceed();
        System.out.println(
            "Thread " + Thread.currentThread().getId() +
            "[" + id.get() +
            "] <<< " + methodSignature
        );
        return result;
    }
}