package de.scrum_master.aspect;

import static org.springframework.core.annotation.AnnotatedElementUtils.getMergedAnnotationAttributes;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * See https://stackoverflow.com/a/53892842/1082681
 */
@Aspect
public class RequestMappingAspect {
  @Before(
    "execution(@org.springframework.web.bind.annotation.RequestMapping * *(..)) ||" +
    "execution(@(@org.springframework.web.bind.annotation.RequestMapping *) * *(..))"
  )
  public void metaMapping(JoinPoint thisJoinPoint) {
    System.out.println(thisJoinPoint);
      AnnotationAttributes annotationAttributes = getMergedAnnotationAttributes(
        ((MethodSignature) thisJoinPoint.getSignature()).getMethod(),
        RequestMapping.class
      );
      for (String value : (String[]) annotationAttributes.get("value"))
        System.out.println("  value = " + value);
      for (RequestMethod method : (RequestMethod[]) annotationAttributes.get("method"))
        System.out.println("  method = " + method);
  }
}