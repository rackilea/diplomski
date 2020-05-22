import java.util.Collections;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.net.SocketAppender;
import org.apache.log4j.net.SyslogAppender;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;
import org.jboss.logmanager.ExtLogRecord;
import org.jboss.logmanager.log4j.handlers.Log4jAppenderHandler;


public class SocketHandler extends Handler {

    private final Log4jAppenderHandler log4j = new Log4jAppenderHandler(new SocketAppender());

    @Override
    public void publish(LogRecord record) {
        if (record == null) {
            return;
        }
        ExtLogRecord extRecord;
        if (record instanceof ExtLogRecord) {
            extRecord = (ExtLogRecord) record;
        } else {
            extRecord = ExtLogRecord.wrap(record);
        }
        if (isLoggable(record)) {
            LoggingEvent event = new LoggingEvent(extRecord.getLoggerClassName(),
                    Logger.getLogger(extRecord.getLoggerClassName()), extRecord.getMillis(),
                    Level.toLevel(extRecord.getLevel().toString()), extRecord.getFormattedMessage(),
                    extRecord.getThreadName(), extRecord.getThrown() == null ? null
                            : new ThrowableInformation(extRecord.getThrown()), extRecord.getNdc(),
                    new LocationInfo(new Throwable(), extRecord.getLoggerClassName()),
                    Collections.singletonMap("org.jboss.logmanager.record", extRecord));
            ((SyslogAppender) log4j.getAppender()).doAppend(event);
            flush();
        }
    }

    @Override
    public void flush() {
        log4j.flush();
    }

    @Override
    public void close() throws SecurityException {
        log4j.close();
    }

    @Override
    public void setFilter(Filter filter) {
        log4j.setFilter(filter);
    }

    @Override
    public void setFormatter(Formatter formatter) {
        log4j.setFormatter(formatter);
    }

    public void setThreshold(String threshold) {
        ((SocketAppender) log4j.getAppender()).setThreshold(Level.toLevel(threshold));
    }

    public void setRemoteHost(String remoteHost) {
        ((SocketAppender) log4j.getAppender()).setRemoteHost(remoteHost);
    }

    public void setPort(String port) {
        try {  
            ((SocketAppender) log4j.getAppender()).setPort(Integer.parseInt(port));  
       } catch (Exception e) {}  
    }

    public void setReconnectionDelay(String reconnectionDelay) {
        try {  
            ((SocketAppender) log4j.getAppender()).setReconnectionDelay(Integer.parseInt(reconnectionDelay));  
       } catch (Exception e) {}  
    }

    public void setLocationInfo(String locationInfo) {
        try {  
            ((SocketAppender) log4j.getAppender()).setLocationInfo(Boolean.parseBoolean(locationInfo));  
       } catch (Exception e) {}  
    }

}