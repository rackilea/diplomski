package org.sample;

import java.util.logging.*;
import java.util.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;

@State(Scope.Thread)
public class ForLoop {
    private static Logger logger = Logger.getLogger("log");
    static {
        logger.setLevel(Level.OFF);
    }

    private StackTraceElement elements[] = new Exception().getStackTrace();

    @Benchmark
    public void a0() {
        for (int i = 0, n = elements.length; i < n; i++) {
            logger.log(Level.WARNING, elements[i].getMethodName());
        }
    }

    @Benchmark
    public void a() {
        for (int i = 0, n = elements.length; i < n; i++) {
            logger.log(Level.WARNING, elements[i].getMethodName());
        }
    }

    @Benchmark
    public void b() {
        for (int i = 0; i < elements.length; i++) {
            logger.log(Level.WARNING, elements[i].getMethodName());
        }
    }

    @Benchmark
    public void c() {
        int n = elements.length;
        for (int i = 0; i < n; i++) {
            logger.log(Level.WARNING, elements[i].getMethodName());
        }
    }

    @Benchmark
    public void d() {
        for (StackTraceElement e: elements) {
            logger.log(Level.WARNING, e.getMethodName());
        }
    }

    @Benchmark
    public void e() {
        Arrays.stream(elements)
            .forEach(item -> logger.log(Level.WARNING, item.getMethodName()));
    }
}