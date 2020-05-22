package de.scrum_master.aspect;

import de.scrum_master.app.Foo;

public aspect ConcreteFooAspect extends FooAspect {
  @Override
  public Foo createT(Object[] args) {
    return new Foo();
  }
}