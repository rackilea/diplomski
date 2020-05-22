public void initialize(ConfigurableWebApplicationContext applicationContext) {
    String activeProfileName = null;
    String location = null;

    try {
      ConfigurableEnvironment environment = applicationContext.getEnvironment();
      String appconfigDir = environment.getProperty(APPCONFIG);
      if (appconfigDir == null ) {
        logger.error("missing property: " + APPCONFIG);
        appconfigDir = "/tmp";
      }
      String[] activeProfiles = environment.getActiveProfiles();

      for ( int i = 0; i < activeProfiles.length; i++ ) {
        activeProfileName = activeProfiles[i];
        MutablePropertySources propertySources = environment.getPropertySources();
        location = "file://" + appconfigDir + activeProfileName + ".properties";
        addPropertySource(applicationContext, activeProfileName,
                location, propertySources);
        location = "classpath:/" + activeProfileName + ".properties";
        addPropertySource(applicationContext, activeProfileName,
                          location, propertySources);
      }
      logger.debug("environment: '{}'", environment.getProperty("env"));

    } catch (IOException e) {
      logger.info("could not find properties file for active Spring profile '{}' (tried '{}')", activeProfileName, location);
      e.printStackTrace();
    }
  }

  private void addPropertySource(ConfigurableWebApplicationContext applicationContext, String activeProfileName,
                                 String location, MutablePropertySources propertySources) throws IOException {
    Resource resource = applicationContext.getResource(location);
    if ( resource.exists() ) {
      ResourcePropertySource propertySource = new ResourcePropertySource(location);
      propertySources.addLast(propertySource);
    } else {
      logger.info("could not find properties file for active Spring profile '{}' (tried '{}')", activeProfileName, location);
    }
  }