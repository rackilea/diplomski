package com.sample;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.microsoft.applicationinsights.TelemetryConfiguration;
import com.microsoft.applicationinsights.web.internal.WebRequestTrackingFilter;

@Configuration
@ComponentScan("com.microsoft.applicationinsights.web.spring")
public class AppInsightsConfig {
    private String insightsKey = "appInsightsKeyXX"; 

    @Bean
    public String telemetryConfig() {
        if (insightsKey != null) {
            TelemetryConfiguration.getActive().setInstrumentationKey(insightsKey);
        }
        return insightsKey;
    }

    @Bean
    public FilterRegistrationBean aiFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new WebRequestTrackingFilter());
        registration.addUrlPatterns("/**");
        registration.setOrder(1);
        return registration;
    } 

    @Bean(name = "WebRequestTrackingFilter")
    public Filter WebRequestTrackingFilter() {
        return new WebRequestTrackingFilter();
    }   
}