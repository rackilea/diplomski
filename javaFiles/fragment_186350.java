log4j.rootLogger=WARN, console

# add a ConsoleAppender to the logger stdout to write to the console
log4j.appender.console=org.apache.log4j.ConsoleAppender
# use a simple message format
log4j.appender.console.layout=org.apache.log4j.EnhancedPatternLayout
log4j.appender.console.layout.ConversionPattern={\
  "time":"%d{ISO8601}",\
  "level":"%p",\
  "class":"%c{1.}",\
  "message":"%m",\
  "thread":"%t",\
  "fileName":"${file.name}"\
  }%n