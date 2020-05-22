package de.scrum_master.aspect;

import java.util.Random;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import de.scrum_master.app.A;

@Aspect
public class MyAspect {
  private static Random random = new Random();

  @Around("execution(A de.scrum_master.app.MyInterface.*(..))")
  public A interceptCalls(ProceedingJoinPoint thisJoinPoint) throws Throwable {
    if (random.nextBoolean())
      return (A) thisJoinPoint.proceed();
    else
      return new A("Aspect"); 
  }
}