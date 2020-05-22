package com.example.args;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class ConfigService implements InitializingBean {

    private Configurations configurations;

    @Value("${configPath:defaultPath}") // "defaultPath" is used if not specified as arg from command line
    private String configPath;

    // you can use also @PostConstruct and not interface, up to you
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("configPath: " + configPath);
        configurations = setConfig(configPath); // you original setConfig
    }

}