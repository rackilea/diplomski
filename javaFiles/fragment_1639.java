public class AppenderWatcher {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(AppenderWatcher.class);


    public static void hadleLogFileDeletionEvent(String logFile) {
        File file = new File(logFile);
        if (!checkFileExist(file)) {
            logger.info("File {} is not exist. Starting manual rollover...", file.toString());
            // Getting possible appender name by log-file.
            String appenderName = getAppenderNameByFileName(logFile);
            // Getting appender from list of all appender
            RollingFileAppender appender = (RollingFileAppender) getAppender(appenderName);

            if (appender != null) {
                // Manually start rollover logic.
                appender.getManager().rollover();
                logger.info("Rollover finished");
            }
            else {
                logger.error("Can't get appender {}. Please, check lo4j2 config.", appenderName);
            }

        } else {
            logger.warn("Received notification what file {} was deleted, but it exist.", file.getAbsolutePath());
        }
    }

    // Method which checks is file exist. It need to prevent conflicts with Log4J rolling file logic.
    // When Log4j rotate file it deletes it first and create after.
    private static boolean checkFileExist(File logFile) {
        return logFile.exists();
    }

    // Method which gets appender by name from list of all configured appenders.
    private static Appender getAppender(String appenderName) {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        return ctx.getConfiguration().getAppenders().get(appenderName);
    }

    // Method which returns name of appender by log file name.
    // ===Here I'm explaining some customer specific moments of log4j config.
    private static String getAppenderNameByFileName(String fileName) {
        return getLoggerNameByFileName(fileName) + "_LOG";
    }

    // This method fully customer specific. 
    private static String getLoggerNameByFileName(String fileName) {
        // File name looks like "../log/temp/uber.log" (example).
        String[] parts = fileName.split("/");

        // Last part should look like "uber.log"
        String lastPart = parts[parts.length - 1];

        // We need only "uber" part.
        String componentName = lastPart.substring(0, lastPart.indexOf("."));
        return componentName.toUpperCase();
    }
}