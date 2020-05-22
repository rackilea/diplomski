log4j.rootLogger=INFO,R, FILE
log4j.appender.R=org.apache.log4j.ConsoleAppender
log4j.appender.R.layout=org.apache.log4j.PatternLayout
log4j.appender.R.layout.ConversionPattern=%d{ISO8601} %5p %t %c - %m%n

log4j.appender.FILE=org.apache.log4j.DailyRollingFileAppender
log4j.appender.FILE.layout=org.apache.log4j.PatternLayout
log4j.appender.FILE.layout.ConversionPattern=%d{ISO8601} %5p %t %c - %m%n
log4j.appender.FILE.File=/home/kshitiz/Documents/tomcat.log
log4j.appender.FILE.DatePattern='.'yyyy-MM-dd

# Application logging options
log4j.logger.org.apache=ERROR
log4j.logger.org.springframework.jdbc.core.JdbcTemplate=DEBUG
log4j.logger.MySQL=ERROR
log4j.logger.org.springframework=DEBUG
log4j.logger.jdbc.sqlonly=OFF
log4j.logger.jdbc.sqltiming=ERROR
log4jdbc.sqltiming.error.threshold=10
log4j.logger.jdbc.audit=OFF
log4j.logger.jdbc.resultset=ERROR
log4j.logger.jdbc.connection=ALL
log4j.logger.jdbc.resultsettable=OFF


# Setup vm levels
log4j.logger.vm.none=FATAL
log4j.logger.vm.error=ERROR
log4j.logger.vm.warn=WARN
log4j.logger.vm.info=INFO
log4j.logger.vm.debug=DEBUG