package com.configuration;

import com.Currency;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "currencies")
public class CurrencyConfiguration {

    private Map<String, Currency> mappings;

    public Map<String, Currency> getMappings() {
        return mappings;
    }

    public void setMappings(Map<String, Currency> mappings) {
        this.mappings = mappings;
    }
}