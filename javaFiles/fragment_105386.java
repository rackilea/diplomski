log4j.rootLogger = DEBUG, rollingAppender
log4j.appender.rollingAppender=org.apache.log4j.rolling.RollingFileAppender
log4j.appender.rollingAppender.rollingPolicy=org.apache.log4j.rolling.TimeBasedRollingPolicy
log4j.appender.rollingAppender.rollingPolicy.fileNamePattern=F:/temp/app%d{yyyy-MM-dd}.log
log4j.appender.rollingAppender.layout=org.apache.log4j.PatternLayout
log4j.appender.rollingAppender.layout.ConversionPattern=[%p] %d %c %M - %m%n