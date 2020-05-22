package de.scrum_master.aspect;

import de.scrum_master.app.Foo;

public abstract aspect FooAspect extends GenericAspect<Foo> {
  pointcut callMethod():
    call(Foo *(..));
}