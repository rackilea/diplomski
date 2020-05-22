log4j.appender.P=org.apache.log4j.DailyRollingFileAppender
log4j.appender.P.File=c:/log/log.txt
log4j.appender.P.Append=true
log4j.appender.P.DatePattern='.'yyy-MM-dd
log4j.appender.P.layout=org.apache.log4j.PatternLayout
log4j.appender.P.layout.ConversionPattern=%d{MM-dd HH:mm:ss.S} %t %m%n