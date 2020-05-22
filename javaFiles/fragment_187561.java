package de.scrum_master.aspect;

import java.lang.annotation.Annotation;

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
    for (RequestMethod method : requestMapping.method())
      System.out.println("  " + method);
  }

  @Before("execution(@(@org.springframework.web.bind.annotation.RequestMapping *) * *(..))")
  public void metaMapping(JoinPoint thisJoinPoint) {
    System.out.println(thisJoinPoint);
    for (Annotation annotation : ((MethodSignature) thisJoinPoint.getSignature()).getMethod().getAnnotations()) {
      RequestMapping requestMapping = annotation.annotationType().getAnnotation(RequestMapping.class);
      if (requestMapping == null)
        continue;
      for (RequestMethod method : requestMapping.method())
        System.out.println("  " + method);
    }
  }

}