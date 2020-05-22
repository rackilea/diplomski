public void updateFichierLogNames(String warnFileName, String infoFileName, String errorFileName) {
        Properties props = new Properties(); 
    try { 
        InputStream configStream = getClass().getResourceAsStream( "/log4j.properties"); 
        props.load(configStream); 
        configStream.close(); 
    } catch (IOException e) { 
        System.out.println("Error: Cannot laod configuration file"); 
    } 

    props.setProperty("log4j.appender.infoFile.File", infoFileName); 
    props.setProperty("log4j.appender.warnFile.File", warnFileName); 
    props.setProperty("log4j.appender.errorFile.File", errorFileName); 

    LogManager.resetConfiguration(); 
    PropertyConfigurator.configure(props); 

    }
}