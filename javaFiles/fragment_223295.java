package net.meisen.tomcat.logging;

import org.apache.juli.logging.Log;
import org.apache.log4j.Logger;

public class Log4jLog implements Log {
    private final Logger logger;

    // this constructor is important, otherwise the ServiceLoader cannot start
    public Log4jLog() {
        logger = Logger.getLogger(Log4jLog.class);
    }

    // this constructor is needed by the LogFactory implementation
    public Log4jLog(final String name) {
        logger = Logger.getLogger(name);
    }

    // now we have to implement the `Log` interface
    @Override
    public boolean isFatalEnabled() {
        return true;
    }

    // ... more isLevelEnabled()

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    // ... and also all the fatal(...) - trace(...) methods

    @Override
    public void fatal(final Object msg) {
        logger.fatal(msg);
    }

    @Override
    public void fatal(final Object msg, final Throwable throwable) {
        logger.fatal(msg, throwable);
    }
}