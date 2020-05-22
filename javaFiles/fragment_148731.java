package com.package1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object o = context.getBean("camera");
        System.out.println("class=" + o.getClass());
        Camera camera = (Camera) context.getBean("camera");
        camera.snap();
        context.close();
    }
}