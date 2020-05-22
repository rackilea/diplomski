public Logger generateLogger(String parent, String name, String logDirectory, String filePattern, String fileThreshold) {
    // TODO Auto-generated method stub

    //Create Logger 
            String loggerName = parent + "." + name;
            Logger log = Logger.getLogger(loggerName);


            //Create Logging File Appender
            RollingFileAppender fileApp = new RollingFileAppender();
            fileApp.setName("Broker." + loggerName + "_FileAppender");
            fileApp.setFile(logDirectory +"/"+ name+".log");
            fileApp.setLayout(new PatternLayout(filePattern));
            fileApp.setThreshold(Level.toLevel(fileThreshold));
            fileApp.setAppend(true);
            fileApp.activateOptions();

            log.addAppender(fileApp);


            return log;     
}