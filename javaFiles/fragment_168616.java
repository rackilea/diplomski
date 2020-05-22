log4j.appender.oozie=org.apache.log4j.rolling.RollingFileAppender
log4j.appender.oozie.RollingPolicy=org.apache.oozie.util.OozieRollingPolicy
log4j.appender.oozie.File=${oozie.log.dir}/oozie.log
log4j.appender.oozie.Append=true
log4j.appender.oozie.layout=org.apache.log4j.PatternLayout
log4j.appender.oozie.layout.ConversionPattern=%d{ISO8601} %5p %c{1}:%L - %m%n
log4j.appender.oozie.RollingPolicy.FileNamePattern=${log4j.appender.oozie.File}-%d{yyyy-MM-dd-HH}
log4j.appender.oozie.RollingPolicy.MaxHistory=720