package com.test.extractor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean(name="testExtractorFactory")
    public TestExtractorFactory testExtractorFactory(){
        return new TestExtractorFactory();
    }
}