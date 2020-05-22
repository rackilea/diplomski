log4j.rootLogger = DEBUG, R

log4j.appender.R=org.apache.log4j.DailyRollingFileAppender
log4j.appender.R.File=E:/testroot.log

log4j.appender.R.layout=org.apache.log4j.PatternLayout
log4j.appender.R.layout.ConversionPattern=%d{DATE} %-5p %c:%L %x - %m%n


##########################################################################
################## Appender for Other Logger  ############################
##########################################################################
log4j.logger.TestLog=DEBUG, cache
log4j.additivity.TestLog=false

log4j.appender.cache=org.apache.log4j.DailyRollingFileAppender
log4j.appender.cache.File=E:/testcache.log
log4j.appender.cache.layout=org.apache.log4j.PatternLayout
log4j.appender.cache.layout.ConversionPattern=%d{dd/MM/yyyy HH:mm:ss} %c %m%n