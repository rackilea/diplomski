package liquibase.ext.logging; // this is *very* important

import liquibase.changelog.ChangeSet;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.logging.core.AbstractLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Liquibase finds this class by itself by doing a custom component scan (sl4fj wasn't generic enough).
 */
public class LiquibaseLogger extends AbstractLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiquibaseLogger.class);
    private String name = "";

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void severe(String message) {
        LOGGER.error("{} {}", name, message);
    }

    @Override
    public void severe(String message, Throwable e) {
        LOGGER.error("{} {}", name, message, e);
    }

    @Override
    public void warning(String message) {
        LOGGER.warn("{} {}", name, message);
    }

    @Override
    public void warning(String message, Throwable e) {
        LOGGER.warn("{} {}", name, message, e);
    }

    @Override
    public void info(String message) {
        LOGGER.info("{} {}", name, message);
    }

    @Override
    public void info(String message, Throwable e) {
        LOGGER.info("{} {}", name, message, e);
    }

    @Override
    public void debug(String message) {
        LOGGER.debug("{} {}", name, message);
    }

    @Override
    public void debug(String message, Throwable e) {
        LOGGER.debug("{} {}", message, e);
    }

    @Override
    public void setLogLevel(String logLevel, String logFile) {
    }

    @Override
    public void setChangeLog(DatabaseChangeLog databaseChangeLog) {
    }

    @Override
    public void setChangeSet(ChangeSet changeSet) {
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }
}