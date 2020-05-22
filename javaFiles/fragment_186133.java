# Root logger option
log4j.rootLogger=DEBUG, file, us
# Direct log messages to a plaintext log 
log4j.appender.file=org.apache.log4j.FileAppender
log4j.appender.file.File=public_html/news.log
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1}:%L - %m%n
log4j.appender.stderr=org.apache.log4j.ConsoleAppender
log4j.appender.stderr.layout.ConversionPattern=%d{ABSOLUTE} %5p %c{1} %L - %m%n
log4j.appender.stderr.layout=org.apache.log4j.PatternLayout