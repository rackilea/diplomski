package de.scrum_master.aspect;

import org.junit.Test;

public aspect TestResultInterceptor {
    pointcut testMethods() :
        execution(@Test public void *(..));

    after() returning : testMethods() {
        System.out.println(
            "Test OK: " +
            thisJoinPointStaticPart.getSignature()
        );
    }

    after() throwing (Throwable throwable) : testMethods() {
        System.out.println(
            (throwable instanceof AssertionError ? "Test failed: " : "Error during test: ") +
            thisJoinPointStaticPart.getSignature()
        );
        System.out.println("  " + throwable);
    }
}