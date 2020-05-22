package com.test.thread;

import java.util.concurrent.*;

public enum MethodNames {
ONE {
    @Override
    public Callable<I> worker() {
        return new Callable<I>() {
            @Override
            public I call() throws InterruptedException {
                System.out.println("Thread1");
                TimeUnit.SECONDS.sleep(30);
              return new A();
            }};
    }
},
TWO {
    @Override
    public Callable<I> worker() throws InterruptedException {
        return new Callable<I>() {
            @Override
            public I call() throws InterruptedException {
                System.out.println("Thread2");
                TimeUnit.SECONDS.sleep(30);
              return new B();
            }};
    }
},
THREE {
    @Override
    public Callable<I> worker() throws InterruptedException {
        return new Callable<I>() {
            @Override
            public I call() throws InterruptedException {
                System.out.println("Thread3");
                TimeUnit.SECONDS.sleep(30);
              return new C();
            }};
    }
},
FOUR {
    @Override
    public Callable<I> worker() throws InterruptedException {
        return new Callable<I>() {
            @Override
            public I call() throws InterruptedException {
                System.out.println("Thread");
                TimeUnit.SECONDS.sleep(30);
              return new D();
            }};
    }
};
public abstract Callable<I> worker() throws InterruptedException;