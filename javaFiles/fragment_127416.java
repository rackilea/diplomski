package de.scrum_master.aspect;

import de.scrum_master.app.MyAnnotation;

public aspect MyAnnotationAspect {
  Object around(MyAnnotation annotation, String word) :
    @annotation(annotation) && set(String *) && args(word)
  {
    System.out.println(thisJoinPoint);
    Object result = null;
    try {
      result = proceed(annotation, "altered value");
    } catch (Throwable ex) {
      throw new RuntimeException(ex);
    }
    return result;
  }
}