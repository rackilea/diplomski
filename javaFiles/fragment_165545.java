package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CounterAspect {
  @Around("execution(* *.*(..)) && @annotation(counter)")
  public void myBeforeLogger(ProceedingJoinPoint joinPoint, Counter counter) {
    System.out.println(joinPoint + " -> " + counter.name());
  }
}