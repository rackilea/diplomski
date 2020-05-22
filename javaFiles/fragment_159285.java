package de.scrum_master.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SingleThreadAspect {
    @Before("execution(* de.scrum_master.app.Plain.getValue(..)) && cflow(execution(* de.scrum_master.app.Connector.getStart(..)))")
    public void interceptControlFlow(JoinPoint thisJoinPoint) {
        System.out.println(thisJoinPoint);
    }
}