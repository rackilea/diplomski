# This is the default logger, simply logs to console
log4j.logger.com.foo.bar=DEBUG,A1
log4j.appender.A1=org.apache.log4j.ConsoleAppender
log4j.appender.A1.layout=org.apache.log4j.PatternLayout

# Note the Pattern here, emits a lot of stuff - btw, don't use this in production
# %C is expensive - see the Javadoc for ConversionPattern for the meaning of all
# the % modifiers:
log4j.appender.A1.layout.ConversionPattern=%d{MMM dd, HH:mm:ss} [%C{2}] %-5p - %m%n

# Logging to file can be enabled by using this one
log4j.logger.com.example=DEBUG, R

log4j.appender.R=org.apache.log4j.RollingFileAppender
log4j.appender.R.File=/var/log/generic.log
log4j.appender.R.MaxFileSize=100KB
# Keep one backup file
log4j.appender.R.MaxBackupIndex=1

# This is the most minimalist layout you can have: just the 'm'essage is emitted
# (and a \n newline):
log4j.appender.R.layout=org.apache.log4j.PatternLayout
log4j.appender.R.layout.ConversionPattern=%m%n