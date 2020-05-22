package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import de.scrum_master.app.MyClass;
import de.scrum_master.app.TrackInfo;

@Aspect
public class SimpleAspect {
  @Around("execution(* de.scrum_master.app.MyClass.processTracker(..)) && args(trackInfo) && target(myClass)")
  public void modifyValidityCheck(ProceedingJoinPoint thisJoinPoint, TrackInfo trackInfo, MyClass myClass) throws Throwable {
    if (trackInfo.getInfo().equalsIgnoreCase("special")) {
      // Kick off processing based on some special logic
      myClass.process(trackInfo);
    }
    else {
      // Proceed normally
      thisJoinPoint.proceed();
    }
  }
}