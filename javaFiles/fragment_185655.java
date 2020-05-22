name=PropertiesConfig

rootLogger.level=debug
rootLogger.appenderRefs=stdout, file
rootLogger.appenderRef.stdout.ref=StandardOutput
rootLogger.appenderRef.file.ref=LogFile

appenders=console, file

## Direct log messages to file
appender.file.type=File
appender.file.name=LogFile
appender.file.fileName=logs/bbt_${current.date}.log
appender.file.layout.type=PatternLayout
appender.file.layout.pattern=%5p | %d | %m%n

# Direct log messages to terminal
appender.console.type=Console
appender.console.name=StandardOutput
appender.console.layout.type=PatternLayout
appender.console.layout.pattern=%5p | %d | %m    %n