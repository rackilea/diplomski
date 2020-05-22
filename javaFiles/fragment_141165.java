# Define the appender which is the RollingFileAppender in the Log4j extras packages
log4j.appender.FILE=org.apache.log4j.rolling.RollingFileAppender
# Define a the RollingPolicy for this Appender
# More information at http://logging.apache.org/log4j/companions/extras/apidocs/org/apache/log4j/rolling/TimeBasedRollingPolicy.html
log4j.appender.FILE.RollingPolicy=org.apache.log4j.rolling.TimeBasedRollingPolicy
# Define the active file name for this RollingPolicy this is the file were current log is placed
log4j.appender.FILE.RollingPolicy.ActiveFileName=@LOG_DIR@/web.log
# Define the file name for the rolling policy. This file location contains a pattern that specifies how often the file will roll over and if compression should occur or not.
log4j.appender.FILE.RollingPolicy.FileNamePattern=@LOG_DIR@/web.%d{yyyy-MM-dd}-00-00.log.gz