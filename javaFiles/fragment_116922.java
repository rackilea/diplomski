package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import de.scrum_master.app.MySpecificException;

@Aspect
public class ExceptionLogger {
  @AfterThrowing(value = "(execution(* *.*(..)))", throwing = "mySpecificException")
  public void logException(JoinPoint thisJoinPoint, MySpecificException mySpecificException) {
    System.out.println(thisJoinPoint + " -> " + mySpecificException);
  }
}