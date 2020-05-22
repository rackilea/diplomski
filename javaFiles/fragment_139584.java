log4j.appender.S=org.apache.log4j.RollingFileAppender
log4j.appender.S.File=${myWebapp-instance-root}/log/External.log
log4j.appender.S.MaxFileSize=1MB
log4j.appender.S.MaxBackupIndex=10
log4j.appender.S.layout=org.apache.log4j.PatternLayout
log4j.appender.S.layout.ConversionPattern=%d %p %t %c - %m%n