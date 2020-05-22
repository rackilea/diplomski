String prop = System.getProperty("log4j.configuration");
    if (prop == null) prop = "log4j.properties";
    URL log4jConfig = Loader.getResource(prop);
    if (log4jConfig.getProtocol().equalsIgnoreCase("file")) {
        PropertyConfigurator.configureAndWatch(log4jConfig.getFile().substring(1), 10000);
    }
    else {
        // cannot monitor if file changed because URL is not a file
    }