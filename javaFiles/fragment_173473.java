package de.scrum_master.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect TraceAspect {
  pointcut executedMethods(Object targetObject) :
    execution(!static * *(..)) && target(targetObject);

  before(Object targetObject) : executedMethods(targetObject) {
    Logger log = LoggerFactory.getLogger(targetObject.getClass());
    log.info("Entering " + thisJoinPoint);
  }

  after(Object targetObject) : executedMethods(targetObject) {
    Logger log = LoggerFactory.getLogger(targetObject.getClass());
    log.info("Exiting " + thisJoinPoint);
  }
}