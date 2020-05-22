<conversionRule conversionWord="boundedMsg" converterClass="com.package.util.logging.converters.LongMessageConverter">

<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
  <encoder>
    <pattern>%boundedMsg{25} [%thread] - %msg%n</pattern>
  </encoder>
</appender>