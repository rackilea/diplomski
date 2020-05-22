package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("myApp/MyApp.xml");
        MessageSource myProperties = (MessageSource) ctx.getBean("myProperties");
        while (true) {
            System.out.println(myProperties.getMessage("myApp.propertyOne", null, null));
            Thread.sleep(1000);
        }
    }
}