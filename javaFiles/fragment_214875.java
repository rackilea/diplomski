package de.scrum_master.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SomeAspect {
  private static ThreadLocal<Boolean> isInPointcut = new ThreadLocal<Boolean>() {
    @Override protected Boolean initialValue() { return false; }
  };

  @Pointcut("execution(* *(..)) && if()")
  public static boolean allMethodCalls() {
    if (isInPointcut.get())
      return false;
    isInPointcut.set(true);
    boolean result = PropertyReader.hasSpecificProperty();
    isInPointcut.set(false);
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