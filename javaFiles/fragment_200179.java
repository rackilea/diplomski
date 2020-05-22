package com.example.args;

import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityService 
        implements ApplicationRunner { // not really needed, just for logging in run

    public static void main(String[] args) {
        SpringApplication.run(SecurityService.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // for logging only
        System.out.println("NonOptionArgs: " + args.getNonOptionArgs());
        Set<String> optionNames = args.getOptionNames();
        System.out.println("OptionArgs: " + optionNames);
        for (String optionName : optionNames) {
            System.out.println(optionName + ": " + args.getOptionValues(optionName));
        }
    }
}