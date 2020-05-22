log4j.rootCategory=DEBUG, O

log4j.appender.O=org.apache.log4j.ConsoleAppender
log4j.appender.O.layout=org.apache.log4j.PatternLayout
log4j.appender.O.layout.ConversionPattern=[%d{ISO8601}]%5p%6.6r[%t]%x - %C.%M(%F:%L) - %m%n

log4j.appender.MESSAGE=org.apache.log4j.RollingFileAppender
log4j.appender.MESSAGE.File=target/logs/messages.log
log4j.appender.MESSAGE.MaxFileSize=1000KB
log4j.appender.MESSAGE.MaxBackupIndex=100
log4j.appender.MESSAGE.layout=org.apache.log4j.PatternLayout
log4j.appender.MESSAGE.layout.ConversionPattern=[%d{ISO8601}]%5p%6.6r[%t]%x - %C.%M


log4j.appender.**MESSAGE2**=org.apache.log4j.RollingFileAppender
log4j.appender.**MESSAGE2**.File=target/logs/**messages2**.log
log4j.appender.**MESSAGE2**.MaxFileSize=1000KB
log4j.appender.**MESSAGE2**.MaxBackupIndex=100
log4j.appender.**MESSAGE2**.layout=org.apache.log4j.PatternLayout
log4j.appender.**MESSAGE2**.layout.ConversionPattern=[%d{ISO8601}]%5p%6.6r[%t]%x - %C.%M    

log4j.category.failedMessagesLog=INFO, MESSAGE , **MESSAGE2**