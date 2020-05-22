package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Transformer getTransformerBean() {
        return new Transformer("hello spring");
    }

    @Bean
    public String getStringBean() {
        return new String();
    }
}