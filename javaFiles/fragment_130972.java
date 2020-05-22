package com.test.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Dispatcher {

public void dispatch() throws InterruptedException, ExecutionException {
    Map<MethodNames, Future<I>> reponse = new HashMap<MethodNames, Future<I>>();
    ExecutorService cachePool = Executors.newCachedThreadPool();
    for (MethodNames methodNames : MethodNames.values()) {
        Future<I> future = cachePool.submit(methodNames.worker());
        reponse.put(methodNames, future);
    }
    cachePool.awaitTermination(5, TimeUnit.MINUTES);
    for(MethodNames key : reponse.keySet()) {
        I result = reponse.get(key).get();
        System.out.println("result :: " + result);
    }
}

public static void main(String[] args) throws InterruptedException, ExecutionException {
    new Dispatcher().dispatch();
}