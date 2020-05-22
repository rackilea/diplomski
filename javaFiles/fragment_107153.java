log4j.rootLogger=ERROR
log4j.appender.axisLogFile=org.apache.log4j.RollingFileAppender
log4j.appender.axisLogFile.File=soap-messages.log
log4j.appender.axisLogFile.layout=org.apache.log4j.PatternLayout
log4j.appender.axisLogFile.layout.ConversionPattern=[%d{DATE} - %-5p] %m%n
log4j.logger.org.apache.axis.transport.http.HTTPSender=DEBUG, axisLogFile