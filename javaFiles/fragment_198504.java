Properties props = new Properties();
    try {
         InputStream configStream = Thread.class.getResourceAsStream("/log4j.properties");
         if (configStream == null) {
             throw new RuntimeException();
         }
         props.load(configStream);
         configStream.close();
    } catch(Throwable e) {
        System.out.println("Error: Cannot load log4j configuration file ");
    }

    props.setProperty("log4j.appender.ERROREMAIL.Subject", emailRecipients);

    LogManager.resetConfiguration();
    PropertyConfigurator.configure(props);