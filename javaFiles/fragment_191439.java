log4j2.appender.console.type = Console
log4j2.appender.console.name = console
log4j2.appender.console.layout.type = PatternLayout
log4j2.appender.console.layout.pattern = %c/%C ${sd:type}/${map:key1} [%p] %m%n
log4j2.rootLogger.level = info
log4j2.rootLogger.appenderRef.file.ref = console