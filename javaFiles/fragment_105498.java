package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    AppConfig appConfig;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    public void start() {
        System.out.println("Start");
        System.out.println("AppConfig: {}" + appConfig);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            this.start();
        };
    }
}