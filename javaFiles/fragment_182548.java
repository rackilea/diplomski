package de.scrum_master.aspect;

import java.lang.annotation.Annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.SoftException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import annotations.MyAnnotation;

@Aspect
public class ArgCatcherAspect {
    @Before("execution(public * *(.., @MyAnnotation (*), ..))")
    public void interceptMethodsWithAnnotatedParameters(JoinPoint thisJoinPoint) {
        System.out.println(thisJoinPoint);
        MethodSignature signature = (MethodSignature) thisJoinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        Annotation[][] annotations;
        try {
            annotations = thisJoinPoint.getTarget().getClass().
                getMethod(methodName, parameterTypes).getParameterAnnotations();
        } catch (Exception e) {
            throw new SoftException(e);
        }
        int i = 0;
        for (Object arg : thisJoinPoint.getArgs()) {
            for (Annotation annotation : annotations[i]) {
                if (annotation.annotationType() == MyAnnotation.class) {
                    System.out.println("  " + annotation + " -> " + arg);
                    // Verify 'arg' here or do whatever
                }
            }
            i++;
        }
    }
}