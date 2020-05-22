String logFile = System.getProperty("java.util.logging.config.file");
        if(logFile == null){
            LogManager.getLogManager().readConfiguration(ReportGenerator.class.getClassLoader().getResourceAsStream("logging.properties"));
        }                
        Logger logger = Logger.getLogger(ReportGenerator.class.getName());
        logger.log(Level.INFO, "LOG THIS");