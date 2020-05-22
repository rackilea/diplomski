log4j.logger.Broker=DEBUG, BrokerFile

    # Broker Appenders
    # Broker File Appender
        log4j.appender.BrokerFile=org.apache.log4j.RollingFileAppender
        log4j.appender.BrokerFile.File=C:/Documents and Settings/gr2cher/My Documents/KTLO/Java/CMInbound/BrokerLogs/Logs/Broker.log
        log4j.appender.BrokerFile.MaxFileSize=1MB
        log4j.appender.BrokerFile.MaxBackupIndex=1
        log4j.appender.BrokerFile.layout=org.apache.log4j.PatternLayout
        log4j.appender.BrokerFile.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
        log4j.appender.BrokerFile.threshold=DEBUG