package de.scrum_master.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Aspect
public class RequestMappingAspect {

  @Before("@annotation(requestMapping) && execution(* *(..))")
  public void genericMapping(JoinPoint thisJoinPoint, RequestMapping requestMapping) {
    System.out.println(thisJoinPoint);
    for (String value : requestMapping.value())
      System.out.println("  value = " + value);
    for (RequestMethod method : requestMapping.method())
      System.out.println("  method = " + method);
  }

  @Before("execution(@(@org.springframework.web.bind.annotation.RequestMapping *) * *(..))")
  public void metaMapping(JoinPoint thisJoinPoint) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    System.out.println(thisJoinPoint);
    for (Annotation annotation : ((MethodSignature) thisJoinPoint.getSignature()).getMethod().getAnnotations()) {
      RequestMapping requestMapping = annotation.annotationType().getAnnotation(RequestMapping.class);
      if (requestMapping == null)
        continue;
      for (String value : (String[]) annotation.annotationType().getDeclaredMethod("value").invoke(annotation))
        System.out.println("  value = " + value);
      for (RequestMethod method : requestMapping.method())
        System.out.println("  method = " + method);
    }
  }

}