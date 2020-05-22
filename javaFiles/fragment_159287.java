package de.scrum_master.aspect;

import de.scrum_master.app.*;

public aspect CrossThreadAspect {
    // Declare a new instance member for our bookkeeping
    private boolean Handler.cflowConnectorGetStart = false;

    // If handler thread is started from Connector.getStart(..), set a mark
    before(Handler handler) :
        call(void Handler.start()) &&
        cflow(execution(* Connector.getStart(..))) &&
        target(handler)
    {
        System.out.println(thisJoinPoint + "\n  doing bookkeeping");
        handler.cflowConnectorGetStart = true;
    }

    // If current thread is a marked Handler, log it
    before() :
        execution(* Plain.getValue(..)) &&
        if(Thread.currentThread() instanceof Handler) &&
        if(((Handler) Thread.currentThread()).cflowConnectorGetStart)
    {
        System.out.println(thisJoinPoint + "\n  triggered from parent thread via Connector.getStart(..)");
    }
}