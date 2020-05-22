package com.afm.web.utility;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.db.ColumnMapping;
import org.apache.logging.log4j.core.appender.db.jdbc.ColumnConfig;
import org.apache.logging.log4j.core.appender.db.jdbc.ConnectionSource;
import org.apache.logging.log4j.core.appender.db.jdbc.JdbcAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JDBCLog {

    @Autowired
    private DataSource dataSourceMSSqlServer;

    // Inner class
    class Connect implements ConnectionSource {

    private DataSource dsource;

    public Connect(DataSource dsource) {
        this.dsource = dsource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.dsource.getConnection();
    }

    }

    public JDBCLog() {}

    @PostConstruct
    private void init(){

    System.out.println("####### JDBCLog init() ########");      
    final LoggerContext ctx = (LoggerContext) LogManager.getContext(false); 
    final Configuration config = ctx.getConfiguration();

    // Here I define the columns I want to log. 
    ColumnConfig[] columnConfigs = new ColumnConfig[] {
        ColumnConfig.newBuilder()
                .setName("CreatedTimeStamp")
                .setPattern(null)
                .setLiteral(null)
                .setEventTimestamp(true)
                .setUnicode(false)
                .setClob(false).build(),
        ColumnConfig.newBuilder()
                .setName("Source")
                .setPattern("%K{className}")
                .setLiteral(null)
                .setEventTimestamp(false)
                .setUnicode(false)
                .setClob(false).build(),
        ColumnConfig.newBuilder()
                .setName("Level")
                .setPattern("%level")
                .setLiteral(null)
                .setEventTimestamp(false)
                .setUnicode(false)
                .setClob(false).build(),
        ColumnConfig.newBuilder()
                .setName("Message")
                .setPattern("%K{message}")
                .setLiteral(null)
                .setEventTimestamp(false)
                .setUnicode(false)
                .setClob(false).build(),
        ColumnConfig.newBuilder()
                .setName("Content")
                .setPattern("%K{exception}")
                .setLiteral(null)
                .setEventTimestamp(false)
                .setUnicode(false)
                .setClob(false).build(),
        ColumnConfig.newBuilder()
                .setName("ProductName")
                .setPattern(null)
                .setLiteral("'DHC'")
                .setEventTimestamp(false)
                .setUnicode(false)
                .setClob(false).build(),
        ColumnConfig.newBuilder()
                .setName("Version")
                .setPattern(null)
                .setLiteral("'1.0'")
                .setEventTimestamp(false)
                .setUnicode(false)
                .setClob(false).build(),
        ColumnConfig.newBuilder()
                .setName("AuditEventType")
                .setPattern("%K{eventId}")
                .setLiteral(null)
                .setEventTimestamp(false)
                .setUnicode(false)
                .setClob(false).build(),
        ColumnConfig.newBuilder()
                .setName("UserId"
                .setPattern("%K{userId}")
                .setLiteral(null)
                .setEventTimestamp(false)
                .setUnicode(false)
                .setClob(false).build(),
        ColumnConfig.newBuilder()
                .setName("LogType")
                .setPattern("%K{logType}")
                .setLiteral(null)
                .setEventTimestamp(false)
                .setUnicode(false)
                .setClob(false).build()
        };

    Appender jdbcAppender = JdbcAppender.newBuilder()
        .setBufferSize(0)
                .setColumnConfigs(columnConfigs)
                .setColumnMappings(new ColumnMapping[]{})
                .setConnectionSource(new Connect(dataSourceMSSqlServer))
                .setTableName("dhc.LogItems")
                .withName("databaseAppender")
                .withIgnoreExceptions(true)
                .withFilter(null)
                .build();

    jdbcAppender.start();
    config.addAppender(jdbcAppender);

    // Create an Appender reference.
    // @param ref The name of the Appender.
    // @param level The Level to filter against.
    // @param filter The filter(s) to use.
    // @return The name of the Appender.
    AppenderRef ref= AppenderRef.createAppenderRef("JDBC_Appender", null, null);
        AppenderRef[] refs = new AppenderRef[] {ref};

        /*
         * Factory method to create a LoggerConfig.
         *
         * @param additivity true if additive, false otherwise.
         * @param level The Level to be associated with the Logger.
         * @param loggerName The name of the Logger.
         * @param includeLocation whether location should be passed downstream
         * @param refs An array of Appender names.
         * @param properties Properties to pass to the Logger.
         * @param config The Configuration.
         * @param filter A Filter.
         * @return A new LoggerConfig.
         * @since 2.6
         */
        LoggerConfig loggerConfig = LoggerConfig.createLogger(
                false, Level.DEBUG, "JDBC_Logger", null, refs, null, config, null);        
        loggerConfig.addAppender(jdbcAppender, null, null);

        config.addLogger("JDBC_Logger", loggerConfig);       
        ctx.updateLoggers();  

        System.out.println("####### JDBCLog init() - DONE ########");  

    }

    public DataSource getDataSource() {
    return dataSourceMSSqlServer;
    }

    public void setDataSource(DataSource dataSourceMSSqlServer) {
    this.dataSourceMSSqlServer = dataSourceMSSqlServer;
    }     

}