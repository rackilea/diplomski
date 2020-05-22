package de.scrum_master.aspect;

import jade.core.behaviours.Behaviour;

public aspect ActionAspect {
    before() :
        execution(* Behaviour.action(..))
    {
        System.out.println(thisJoinPoint);
        Behaviour behaviour = (Behaviour) thisJoinPoint.getThis();
        behaviour.getAgent();
    }

    before(Behaviour behaviour) :
        execution(* Behaviour.action(..)) && this(behaviour)
    {
        System.out.println(thisJoinPoint);
        behaviour.getAgent();
    }
}