package com.test;

public class Service1 implements Service {

    public ServiceKey getKey() {
        return new ServiceKey("one");
    }

}