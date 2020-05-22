package de.scrum_master.aspect;

import de.scrum_master.app.Application;

public aspect MyAspect {
  before() : within(Application) || within(MyOtherAspect) {
    System.out.println(thisJoinPoint);
    System.out.println("    " + thisJoinPoint.getSignature().getClass().getSimpleName());
  }
}