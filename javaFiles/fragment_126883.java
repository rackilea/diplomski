package de.scrum_master.aspect;

import de.scrum_master.app.OuterAnnotation;

public aspect MetaAnnotationAspect {
  after() : within(@(@OuterAnnotation *) *) && execution(* *(..)) {
    System.out.println(thisJoinPoint);
  }
}