package de.scrum_master.aspect;

import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public aspect GenericsAspect {
    pointcut addPointCut(List list, Object newElement) :
        !within(GenericsAspect) &&            // avoid stack overflow due to recursion
        call(* List.add(..)) &&               // intercept all calls to List.add
        args(.., newElement) &&               // capture last method parameter
        if(newElement instanceof Integer) &&  // only capture added int/Integer elements
        target(list);                         // target is a List

    before(List list, Object newElement) :
        addPointCut(list, newElement)
    {
        System.out.println(thisJoinPoint + " -> new element = " + newElement);
        for(Object i : list)
            System.out.println("  " + i);

        // Type erasure in action:
        // During runtime there is no such thing as List<Integer>, only a raw List.
        // Thus, we can easily add a String to a list declared as List<Integer>.
        list.add("#" + newElement + "#");
    }
}