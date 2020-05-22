package de.scrum_master.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LogAspect {
    private ThreadLocal<JoinPoint> enclosingJoinPoint;

    @AfterThrowing(value = "execution(* *(..))", throwing = "e")
    public void log(JoinPoint thisJoinPoint, Throwable e) {
        System.out.println(thisJoinPoint + " -> " + e);
    }

    @Before("execution(* *(..)) && within(de.scrum_master.app..*)")
    public void recordJoinPoint(JoinPoint thisJoinPoint) {
        if (enclosingJoinPoint == null)
            enclosingJoinPoint = ThreadLocal.withInitial(() -> thisJoinPoint);
        else
            enclosingJoinPoint.set(thisJoinPoint);
    }

    @Before("handler(*) && args(e)")
    public void logCaughtException(JoinPoint thisJoinPoint, Exception e) {
        // Exception handler
        System.out.println(thisJoinPoint + " -> " + e);

        // Method signature + parameter types/names
        JoinPoint enclosingJP = enclosingJoinPoint.get();
        MethodSignature methodSignature = (MethodSignature) enclosingJP.getSignature();
        System.out.println("    " + methodSignature);
        Class<?>[] paramTypes = methodSignature.getParameterTypes();
        String[] paramNames = methodSignature.getParameterNames();
        Object[] paramValues = enclosingJP.getArgs();
        for (int i = 0; i < paramNames.length; i++)
            System.out.println("      " + paramTypes[i].getName() + " " + paramNames[i] + " = " + paramValues[i]);

        // Target object upon which method is executed
        System.out.println("    " + enclosingJP.getTarget());

        // Method annotations - attention, reflection!
        Method method = methodSignature.getMethod();
        for (Annotation annotation: method.getAnnotations())
            System.out.println("    " + annotation);
    }
}