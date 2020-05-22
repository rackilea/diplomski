package org.example.application;

@SpringBootApplication(scanBasePackages= {
                      "org.example", 
                      "org.thirdparty.repository"})
@EnableJpaRepositories("org.thirdparty.repository")
public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
}