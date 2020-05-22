package de.scrum_master.aspect;

import de.scrum_master.app.ServiceInput;
import de.scrum_master.app.PublishEventToService;
import de.scrum_master.app.DoStuff;

public privileged aspect PublishEventToServiceAspect {
    pointcut setDetail(DoStuff caller) :
        call(* ServiceInput.setDetail(..)) &&
        cflow(execution(@PublishEventToService * DoStuff+.*(..))) &&
        this(caller);

    after(DoStuff caller) : setDetail(caller) {
        System.out.println(thisJoinPointStaticPart);        
        System.out.println("  " + caller.serviceSAO);       
        System.out.println("  " + caller.serviceInput);     
    }
}