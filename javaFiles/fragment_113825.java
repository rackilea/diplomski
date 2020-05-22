package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public static Endpoint exampleEndpoint() {
        return new Endpoint<String>() {
            @Override
            public String getId() {
                return "example";
            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public boolean isSensitive() {
                return false;
            }

            @Override
            public String invoke() {
                return "example";
            }
        };
    }
}