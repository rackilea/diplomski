package com.realitylabs.spa.tool;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Pablo Karlsson
 *
 * ConfigurableApplicationContextInitializer sets the spring profile
 * before application initialization so we can use dependency injection
 * based on profile. This allows us to mock services like SGCSClientService
 * In development mode.
 */
public class ConfigurableApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

  @Override
  public void initialize(ConfigurableApplicationContext context) {

    String APP_ENV = System.getenv("APP_ENV");

    if(APP_ENV == null) {
      throw new RuntimeException("Please set APP_ENV to production or development");
    }

    APP_ENV = APP_ENV.toLowerCase();

    if(!APP_ENV.equals("development") && !APP_ENV.equals("production")) {

      throw new RuntimeException("Please set APP_ENV to production or development");
    }

    context.getEnvironment().setActiveProfiles(APP_ENV);
  }
}