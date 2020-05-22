package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        ServiceManager serviceManager = context.getBean(ServiceManager.class);
        System.out.println(serviceManager.getServiceMap());
    }
}