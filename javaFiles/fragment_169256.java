package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
  @Before("call(* de.scrum_master.app.MyArray.setValue(..))")
  public void logSourceLocation(JoinPoint thisJoinPoint) {
    System.out.println(thisJoinPoint + " -> " + thisJoinPoint.getSourceLocation());
  }
}