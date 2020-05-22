package de.scrum_master.aspect;

import de.scrum_master.app.A;
import de.scrum_master.app.B;

public aspect InstanceCreationCounter {
    private static int count;

    after() : call(A+.new(..)) || call(B+.new(..)) {
        System.out.printf("%4d %s%n", ++count, thisJoinPoint);
    }
}