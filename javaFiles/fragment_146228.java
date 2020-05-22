package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import de.scrum_master.app.Auditable;

@Aspect
public class MyAspect {
  @After("cflow(@annotation(auditable)) && set(@de.scrum_master.app.Id String de.scrum_master..*.*) && args(id)")
  public void pointcutMethod(JoinPoint thisJoinPoint, Auditable auditable, String id) {
    System.out.println(thisJoinPoint);
    System.out.println("  " + auditable);
    System.out.println("  " + id);
  }
}