package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectClass {
  @AfterReturning(
    value = "execution(* de.scrum_master.app.ClassB.*(..)) && args(testString, testInteger)",
    returning = "result"
  )
  public void aspectMethod(JoinPoint joinPoint, String testString, Integer testInteger, String result) {
    System.out.println(joinPoint);
    System.out.println("  testString = " + testString);
    System.out.println("  testInteger = " + testInteger);
    System.out.println("  result = " + result);
  }
}