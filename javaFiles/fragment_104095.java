package com.snaphop.ats.util;

public aspect Blah {
    pointcut sub_nonannotated() : !execution(@LeaveItAlone * Base+.*(..));

    pointcut sub() : execution(* Base+.*(..));

    pointcut notBase() : ! execution(* Base.*(..));

    pointcut cons() : execution(public Base+.new(..)) && ! execution(public Base.new(..));


    //advice sub class methods but not annotation or parent
    Object around() : sub_nonannotated() && sub() && notBase() {
        return proceed();
    }

    //Advice subclass constructors but not Base's constructor
    Object around() : cons() {
        return proceed();
    }
}