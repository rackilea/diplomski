package com.my.newsaggregator.rsscollector;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan (basePackages={"service","com.my.newsaggregator.rsscollector"})
@EnableJpaRepositories(basePackages={"repository"})
@EnableAutoConfiguration
@EntityScan(basePackages={"model"})

public class RsscollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsscollectorApplication.class, "--debug").close();
        System.out.println("done");

    }
}