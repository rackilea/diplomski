package de.scrum_master.aspect;

import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DemoAspect {
    private static ThreadLocal<String> id = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return UUID.randomUUID().toString();
        }
    };

    @Pointcut("execution(* *(..))")
    public void logging() {}

    @Around("logging()")
    public Object tracing(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodSignature = thisJoinPoint.getSignature().toString();
        if (id.get().toString() == null || id.get().toString().length() == 0)
            id.set(UUID.randomUUID().toString());
        System.out.println("Entering into " + methodSignature);
        Object ret = thisJoinPoint.proceed();
        System.out.println(id.get().toString());
        System.out.println("Exiting from " + methodSignature);
        id.remove();
        return ret;
    }
}