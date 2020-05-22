package com.example.demo;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOG.warn("********** Starting the application");
        SpringApplication.run(Application.class, args);
    }

     @Component
    public class MyRunner implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            System.out.println(String.format("%s!!!", "HELLO WORLD"));
            LOG.error(String.format("%s!!!", "HELLO WORLD"));

            Stream.of("John Travolta", "Julia Childs", "Jennifer Anniston", "Helen Hunt", "Rachel Green").forEach(n -> {
                System.out.println(n);
                LOG.error(n);
            });

        }
    }
}