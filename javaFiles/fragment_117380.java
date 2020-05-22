# Define the root logger with appender file 
log4j.rootLogger = DEBUG, FILE

# Pattern to output the caller's file name and line number.
log4j.appender.stdout.layout.ConversionPattern=%-5p : %d{yyyy-MM-dd HH:mm:ss} %c{1}:%L - %m%n

# Define the daily rolling file appender
log4j.appender.FILE=org.apache.log4j.DailyRollingFileAppender
log4j.appender.FILE.File=/logs/app.log
log4j.appender.FILE.DatePattern='.'yyyy-MMM-dd

# Define the layout for the file appender
log4j.appender.FILE.layout=org.apache.log4j.PatternLayout
log4j.appender.FILE.layout.ConversionPattern= %-5p : %d{yyyy-MM-dd HH:mm:ss} %c{1}:%L - %m%n