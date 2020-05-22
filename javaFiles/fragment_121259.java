package com.yourpackage.config;

@Configuration
@ImportResource(
        locations = {
                "classpath:/your-extra-config-1.xml",
                "classpath:/your-extra-config-2.xml",
        })
public class AppConfig {
    ...
}