mo.log.pattern=%n================================%n%d{yyyy-MM-dd-HH-mm-ss}%n%c%n%m %x%n--------------------------------%n
mo.log.datepattern=yyyy-MM-dd-HH-mm-ss

log4j.appender.debug=org.apache.log4j.MoDailyRollingFileAppender
log4j.appender.debug.File=/path/to/Generated/Logs/debug.log
log4j.appender.debug.Append=true
log4j.appender.debug.DatePattern=${mo.log.datepattern}
log4j.appender.debug.layout=org.apache.log4j.PatternLayout
log4j.appender.debug.layout.ConversionPattern=${mo.log.pattern}