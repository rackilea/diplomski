package de.scrum_master.app;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class BuilderCacheAspect {
  private Map<Class<?>, Object> cachedObjects = new HashMap<>();

  @Around("@annotation(de.scrum_master.app.Builder) && execution(* *(..))")
  public Object findOrCreateObject(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    //System.out.println(thisJoinPoint);
    Class<?> returnType = ((MethodSignature) thisJoinPoint.getSignature()).getReturnType();
    Object cachedObject = cachedObjects.get(returnType);
    if (cachedObject == null) {
      cachedObject = thisJoinPoint.proceed();
      cachedObjects.put(returnType, cachedObject);
    }
    return cachedObject;
  }
}