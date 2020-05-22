log4j.appender.DRFA.layout=org.apache.log4j.PatternLayout
log4j.appender.DRFA=org.apache.log4j.rolling.RollingFileAppender
log4j.appender.DRFA.rollingPolicy=org.apache.log4j.rolling.FixedWindowRollingPolicy  
log4j.appender.DRFA.triggeringPolicy=org.apache.log4j.rolling.SizeBasedTriggeringPolicy  
log4j.appender.DRFA.rollingPolicy.ActiveFileName =${hive.log.dir}/${hive.log.file}.log
log4j.appender.DRFA.rollingPolicy.FileNamePattern=${hive.log.dir}/${hive.log.file}-.%i.log.gz
log4j.appender.DRFA.triggeringPolicy.MaxFileSize=10000
log4j.appender.DRFA.rollingPolicy.maxIndex=10