log4j.rootLogger=INFO, MAIN_LOG_FILE

log4j.appender.MAIN_LOG_FILE=org.apache.log4j.RollingFileAppender
log4j.appender.MAIN_LOG_FILE.File=./logs/main.log
log4j.appender.MAIN_LOG_FILE.layout=org.apache.log4j.PatternLayout
log4j.appender.MAIN_LOG_FILE.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5p %c - %m%n

log4j.logger.worker_1=INFO, WORKER_1_LOG_FILE
#log4j.additivity.worker_1=false

log4j.appender.WORKER_1_LOG_FILE=org.apache.log4j.DailyRollingFileAppender
log4j.appender.WORKER_1_LOG_FILE.layout=org.apache.log4j.PatternLayout
log4j.appender.WORKER_1_LOG_FILE.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5p %c - %m%n
log4j.appender.WORKER_1_LOG_FILE.File=./logs/worker1
log4j.appender.WORKER_1_LOG_FILE.DatePattern='-'yyyy-MM-dd-HHmm'.log' 

log4j.logger.worker_2=INFO, WORKER_2_LOG_FILE
#log4j.additivity.worker_2=false
#log4j.logger.worker_2.m.SomethingElse=DEBUG

log4j.appender.WORKER_2_LOG_FILE=org.apache.log4j.DailyRollingFileAppender
log4j.appender.WORKER_2_LOG_FILE.layout=org.apache.log4j.PatternLayout
log4j.appender.WORKER_2_LOG_FILE.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5p %c - %m%n
log4j.appender.WORKER_2_LOG_FILE.File=./logs/worker2
log4j.appender.WORKER_2_LOG_FILE.DatePattern='-'yyyy-MM-dd-HHmm'.log'