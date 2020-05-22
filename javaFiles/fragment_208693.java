public static final String LOG4JAPPENDERRFILE = "log4j.appender.R.File";

  private boolean configureLog4J(String contextName) {
    Properties props = new Properties();
    try {
       InputStream configStream = getClass().getResourceAsStream("/myapp-log4j.properties");
       props.load(configStream);
       configStream.close();
    } catch(IOException e) {
       System.out.println("FATAL! Cannot load log4j configuration file from classpath.");
       e.printStackTrace(System.out);
       return false;
    }

    String logFile = props.getProperty(LOG4JAPPENDERRFILE);
    logFile=logFile.replace("#{context.name}", contextName);
    props.setProperty(LOG4JAPPENDERRFILE, logFile);
    LogManager.resetConfiguration();
    PropertyConfigurator.configure(props);
    return true;
  }