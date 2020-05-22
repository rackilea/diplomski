package com.example;

import com.example.route.A;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource(locations = {"classpath*:/ctxt/B.xml"})
public class DemoApplication {


    public static void main(String[] args) {
        ApplicationContext ctxt = SpringApplication.run(DemoApplication.class, args);

        A a = ctxt.getBean(A.class);
        System.out.println(a.toString());   // A{b=com.example.route.B@5488b5c5}   <-- A init correctly with non-null B


    }
}