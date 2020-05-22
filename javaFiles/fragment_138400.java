<appender name="rollingFileAppender" class="ch.qos.logback.core.rolling.RollingFileAppender">
  <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
    <FileNamePattern>LogFile.%d{yyyy-MM-dd}.log</FileNamePattern>
    <MaxHistory>30</MaxHistory>
  </rollingPolicy>
  <encoder>
    <pattern>%d %-5level [%thread] %logger{0}: %msg%n</pattern>
  </encoder>
</appender>