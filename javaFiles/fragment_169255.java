package de.scrum_master.aspect;

import de.scrum_master.app.MyArray;

public aspect MyAspect {
  before() : call(* MyArray.setValue(..)) {
    System.out.println(thisJoinPoint + " -> " + thisJoinPoint.getSourceLocation());
  }
}