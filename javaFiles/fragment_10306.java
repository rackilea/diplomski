package de.scrum_master.aspect;

import static de.scrum_master.app.Status.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import de.scrum_master.app.Status;
import de.scrum_master.app.TrackInfo;

@Aspect
public class WormholePatternAspect {
  @Pointcut("execution(* de.scrum_master.app.MyClass.processTracker(..)) && args(trackInfo)")
  public static void processTracker(TrackInfo trackInfo) {}

  @Pointcut("execution(* de.scrum_master.app.MyClass.getStatus())")
  public static void getStatus() {}

  @Around("getStatus() && cflow(processTracker(trackInfo))")
  public Status modifyValidityCheck(ProceedingJoinPoint thisJoinPoint, TrackInfo trackInfo) throws Throwable {
    if (trackInfo.getInfo().equalsIgnoreCase("special")) {
      // Return true based on some special logic
      return VALID;
    }
    else {
      // Proceed normally
      return (Status) thisJoinPoint.proceed();
    }
  }
}