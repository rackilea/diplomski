log4j.rootCategory=FATAL, O

log4j.appender.O=org.apache.log4j.varia.NullAppender

log4j.appender.O.layout=org.apache.log4j.PatternLayout

log4j.appender.O.layout.ConversionPattern=[%d{ISO8601}]%5p%6.6r[%t]%x - %C.%M(%F:%L) - %m%n