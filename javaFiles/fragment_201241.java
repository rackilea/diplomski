package com.rationaleemotions.stackoverflow.qn45371087;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelSuiteTest {
    private static final Object lock = new Object();
    private static boolean initialised = false;

    @BeforeClass
    public void beforeClass() {
        synchronized (lock) {
            if (!initialised) {
                init();
                initialised = true;
            }
        }
    }

    private void init() {
        System.err.println("Initialisation done");
    }

    @Test
    public void testMethodOne() {
        System.err.println("This is a test method running on [" + Thread.currentThread().getId() + "]");
    }

}