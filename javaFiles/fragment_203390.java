package xyz.blackmonster.window.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("xyz.blackmonster.window")
@EnableJpaRepositories("xyz.blackmonster.window.repositories")
@EntityScan("xyz.blackmonster.window.models")
public class WindowAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WindowAppApplication.class, args);
    }
}