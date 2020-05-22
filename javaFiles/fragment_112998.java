package com.apptwo.pkg.one;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {
        com.apptwo.pkg.one.config.AppConfig.class,
        com.appone.pkg.two.GlobalAppConfig.class,
        com.appone.pkg.three.AppTwoConfig.class
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}