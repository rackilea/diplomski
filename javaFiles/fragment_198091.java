package com.test;

public class Service2 implements Service {

    public ServiceKey getKey() {
        return new ServiceKey("two");
    }
}