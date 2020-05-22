package de.scrum_master.app;

import de.scrum_master.app.Base;

public aspect MyAspect {
  before() : execution(Base Base.*(..)) {
    System.out.println("Base Base.*(..)   -> " + thisJoinPoint);
  }

  before() : execution(Base+ Base.*(..)) {
    System.out.println("Base+ Base.*(..)  -> " + thisJoinPoint);
  }

  before() : execution(Base Base+.*(..)) {
    System.out.println("Base Base+.*(..)  -> " + thisJoinPoint);
  }

  before() : execution(Base+ Base+.*(..)) {
    System.out.println("Base+ Base+.*(..) -> " + thisJoinPoint);
  }
}