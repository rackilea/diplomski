package de.scrum_master.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SomeAspect {
  private static boolean isInPointcut = false;

  @Pointcut("execution(* *(..)) && if()")
  public static boolean allMethodCalls() {
    if (isInPointcut)
      return false;
    isInPointcut = true;
    boolean result = PropertyReader.hasSpecificProperty();
    isInPointcut = false;
    return result;
  }

  @Pointcut("cflow(adviceexecution()) || within(SomeAspect)")
  public void aspectCalls() {}

  @Before("allMethodCalls() && !aspectCalls()")
  public void logSomething(JoinPoint thisJoinPoint) {
    System.out.println(thisJoinPoint);
    PropertyReader.hasSpecificProperty();
  }
}