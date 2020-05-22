package com.dummy.aspectj;

import java.util.Arrays;
import java.util.Collections;

public class DummyClass{

    public static void main(final String[] args){
        System.out.println(Arrays.asList("One", Collections.singleton("Two")));
        System.out.println("Enough?");
    }

}

package com.dummy.aspectj;

import java.util.Arrays;

public aspect DummyAspect{

    pointcut callWithinMain() : 
        withincode(* com.dummy.aspectj.DummyClass.main(..)) // anything inside DummyClass.main
        && call(* *.*(..));                                 // but only method calls

    before() : callWithinMain() {
        System.out.println("\n***************************************************");
        System.out.println("** Calling:\n**\t"
            + thisJoinPointStaticPart.getSignature()
            + "\n** with arguments:\n**\t "
            + Arrays.deepToString(thisJoinPoint.getArgs()) );
        System.out.println("***************************************************\n");
    }

}