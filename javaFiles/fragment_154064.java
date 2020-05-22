log4j.rootLogger=DEBUG, file, console, file1

log4j.appender.console=org.apache.log4j.ConsoleAppender
logrj.appender.console.Target=System.out
log4j.appender.console.layout=org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=%-5p %c{1} - %m%n

log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.File=logs/justfortesting.log
log4j.appender.file.Append=true
log4j.appender.file.ImmediateFlush=true
log4j.appender.file.Threshold=DEBUG
log4j.appender.file.filter.a=org.apache.log4j.varia.LevelRangeFilter
log4j.appender.file.filter.a.LevelMin=INFO
log4j.appender.file.filter.a.LevelMax=INFO
log4j.appender.file.MaxFileSize=1KB
log4j.appender.file.MaxBackupIndex=2
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d %d{Z} [%t] %-5p (%F:%L) - %m%n

log4j.appender.file1=org.apache.log4j.RollingFileAppender
log4j.appender.file1.File=logs/justfortesting.log
log4j.appender.file1.Append=true
log4j.appender.file1.ImmediateFlush=true
log4j.appender.file1.Threshold=DEBUG
log4j.appender.file1.filter.g=org.apache.log4j.varia.LevelRangeFilter
log4j.appender.file1.filter.g.LevelMin=ERROR
log4j.appender.file1.filter.g.LevelMax=ERROR
log4j.appender.file1.MaxFileSize=1KB
log4j.appender.file1.MaxBackupIndex=2
log4j.appender.file1.layout=org.apache.log4j.PatternLayout
log4j.appender.file1.layout.ConversionPattern=%d %d{Z} [%t] %-5p (%F:%L) - %m%n

log4j.logger.com.log4j=DEBUG, file, console, file1

log4j.additivity.com.log4j=false