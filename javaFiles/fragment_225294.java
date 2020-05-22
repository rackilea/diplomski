package de.scrum_master.aspect;

public abstract aspect GenericAspect<T> {
  public abstract T createT(Object[] args);

  abstract pointcut callMethod();

  T around(Object[] args): callMethod() && args(args) {
    return createT(args);
  }
}