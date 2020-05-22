import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;

public class Main {
    public static void main(String[] args) {
        Logger rootLogger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        Appender<ILoggingEvent> savingAppender = ((ch.qos.logback.classic.Logger)rootLogger).getAppender("savingAppender");

        Logger incidentLogger = LoggerFactory.getLogger("incident");
        Appender<ILoggingEvent> incidentAppender = ((ch.qos.logback.classic.Logger)incidentLogger).getAppender("incidentAppender");

        ((SavingAppender<ILoggingEvent>)savingAppender).clearLog();

        LoggerFactory.getLogger(Main.class).error("Error 1...");
        LoggerFactory.getLogger(Main.class).error("Error 2...");
        LoggerFactory.getLogger(Main.class).error("Error 3...");
        LoggerFactory.getLogger(Main.class).info("Info 1...");
        LoggerFactory.getLogger(Main.class).info("Info 2...");
        LoggerFactory.getLogger(Main.class).info("Info 3...");

        ((SavingAppender<ILoggingEvent>)savingAppender).writeLog(incidentAppender);
    }
}