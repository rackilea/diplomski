status = error
name = PropertiesConfig

property.filename = target/logs/test.log

appender.file.type = File
appender.file.name = LogFile
appender.file.fileName = ${filename}
appender.file.layout.type = PatternLayout
appender.file.layout.pattern = %d %p %C{1.} [%t] %m%n

rootLogger.level = error
rootLogger.appenderRef.stdout.ref = LogFile