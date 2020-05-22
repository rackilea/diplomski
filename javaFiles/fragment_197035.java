package example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

public class Log4j2SetAppenderRefLvlMain {
    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        final Configuration config = ctx.getConfiguration();


        log.info("Before altering the appender!");

        LoggerConfig rootLoggerConfig = config.getLoggers().get("");
        rootLoggerConfig.removeAppender("logFile");
        rootLoggerConfig.addAppender(config.getAppender("logFile"), Level.WARN, null);
        ctx.updateLoggers();

        log.info("After altering the appender!");
        log.warn("After altering the appender!");
    }

}