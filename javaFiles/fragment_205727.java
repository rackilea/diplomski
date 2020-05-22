name=PropertiesConfig
property.filename = logs
#Removed the following line since latest log4j2 does not need it
#appenders = console, user, system

appender.console.type = Console
appender.console.name = STDOUT
appender.console.layout.type = PatternLayout
appender.console.layout.pattern = [%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n

appender.user.type = File
appender.user.name = userLog
appender.user.fileName=${filename}/user.log
appender.user.layout.type=PatternLayout
appender.user.layout.pattern=[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n
#Removed attributes that do not apply to file appender
#appender.user.MaxFileSize=5120KB
#appender.user.MaxBackupIndex=10

appender.system.type = File
appender.system.name = systemLog
appender.system.fileName=${filename}/system.log
appender.system.layout.type=PatternLayout
appender.system.layout.pattern=[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n
#Removed attributes that do not apply to file appender
#appender.system.MaxFileSize=5120KB
#appender.system.MaxBackupIndex=10

#Removed the following line since latest log4j2 does not need it
#Loggers = file
logger.userFile.name = user
logger.userFile.level = All
logger.userFile.appenderRef.user.ref  = userLog

logger.systemFile.name = system
logger.systemFile.level = All
logger.systemFile.appenderRef.system.ref = systemLog

#Adding the following commented lines for reference - this is how you define the root logger in the properties.
#rootLogger.level = info
#rootLogger.appenderRef.console.ref = STDOUT