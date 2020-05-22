package de.scrum_master.aspect;

import java.lang.annotation.Annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class ParameterFilterAspect {
  @Before("@annotation(de.scrum_master.app.MyAnnotation) && execution(* *(..))")
  public void doSomething(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Annotation[][] annotationMatrix = methodSignature.getMethod().getParameterAnnotations();
    for (int i = 0; i < args.length; i++) {
      boolean hasJavaxAnnotation = false;
      for (Annotation annotation : annotationMatrix[i]) {
        if (annotation.annotationType().getPackage().getName().startsWith("javax.")) {
          hasJavaxAnnotation = true;
          break;
        }
      }
      if (!hasJavaxAnnotation)
        System.out.println(args[i]);
    }
  }
}