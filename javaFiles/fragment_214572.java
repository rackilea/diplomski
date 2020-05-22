package de.scrum_master.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public aspect BeanAnnotationChecker {
    declare error :
        @annotation(Component) && !@annotation(Scope) :
        "Spring component without scope declaration found";

    declare error :
        execution(@Autowired *.new(.., @Scope("prototype") *, ..)) && within(@Scope("singleton") *) :
        "singleton bean auto-wired into prototype container via constructor";

    declare error :
        execution(@Autowired * *(.., @Scope("prototype") *, ..)) && within(@Scope("singleton") *) :
        "singleton bean auto-wired into prototype container via setter method";

    declare error :
        set(@Autowired * *) && within(@Scope("singleton") *) :
        "singleton bean auto-wired into prototype container via field assignment";
}