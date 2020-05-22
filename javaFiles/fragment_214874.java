package de.scrum_master.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SomeAspect {
  @Pointcut("execution(* *(..)) && if()")
  public static boolean allMethodCalls() {
    return System.getProperty("specificProperty") != null;
  }

  @Pointcut("cflow(adviceexecution())")
  public void aspectCalls() {}

  @Before("allMethodCalls() && !aspectCalls()")
  public void logSomething(JoinPoint thisJoinPoint) {
    System.out.println(thisJoinPoint);
    PropertyReader.hasSpecificProperty();
  }
}