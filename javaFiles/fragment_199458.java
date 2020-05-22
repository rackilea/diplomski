log4j.rootLogger=DEBUG,INFO,FILE,ERROR_FILE

log4j.appender.FILE=org.apache.log4j.RollingFileAppender
log4j.appender.FILE.file=${catalina.base}/logs/myApplicationLogs.log
log4j.appender.FILE.Append=true
log4j.appender.FILE.Encoding=UTF-8
log4j.appender.FILE.MaxFileSize=5MB
log4j.appender.FILE.MaxBackupIndex=10
log4j.appender.FILE.layout=org.apache.log4j.PatternLayout
log4j.appender.FILE.layout.conversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c:%L - %m%n

    log4j.appender.ERROR_FILE=org.apache.log4j.DailyRollingFileAppender
    log4j.appender.ERROR_FILE.file=${catalina.base}/logs/ERROR_fileName.log
    log4j.appender.ERROR_FILE.DatePattern='.'yyyy-MM-dd'.log'
    log4j.appender.ERROR_FILE.Threshold=ERROR
    log4j.appender.ERROR_FILE.Append=true
    log4j.appender.ERROR_FILE.Encoding=UTF-8
    log4j.appender.ERROR_FILE.MaxFileSize=5MB
    log4j.appender.ERROR_FILE.MaxBackupIndex=10
    log4j.appender.ERROR_FILE.layout=org.apache.log4j.PatternLayout
    log4j.appender.ERROR_FILE.layout.conversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c:%L - %m%n