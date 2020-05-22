log4j.appender.ServerAppender=org.apache.log4j.FileAppender
log4j.appender.ServerAppender.layout=org.apache.log4j.PatternLayout
log4j.appender.ServerAppender.layout.ConversionPattern=%d{dd MMM yyyy HH:mm:ss,SSS} [%t] %-5p %F - %m%n 
log4j.appender.ServerAppender.file=logs/ServerLog.txt
log4j.appender.ServerAppender.threshold=DEBUG

log4j.logger.com.foo.server=TRACE, ServerAppender

log4j.appender.ServerAppender.errorhandler=org.apache.log4j.varia.FallbackErrorHandler
log4j.appender.ServerAppender.errorhandler.logger-ref=com.foo.server
log4j.appender.ServerAppender.errorhandler.appender-ref=FallbackServerAppender

log4j.appender.FallbackServerAppender=org.apache.log4j.FileAppender
log4j.appender.FallbackServerAppender.layout=org.apache.log4j.PatternLayout
log4j.appender.FallbackServerAppender.layout.ConversionPattern=%d{dd MMM yyyy HH:mm:ss,SSS} [%t] %-5p %F - %m%n 
log4j.appender.FallbackServerAppender.file=C:/Temp/Test/fallbackServerLog.txt

log4j.logger.com.foo.error=DEBUG,FallbackServerAppender