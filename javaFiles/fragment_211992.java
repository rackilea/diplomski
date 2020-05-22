<appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
    <file>${LOGS_DIR}/${FILE_NAME}.log</file>
    <encoder>
        <pattern>%d [%thread] %-5level %logger{50} - %msg%n</pattern>
    </encoder>
    <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
        <fileNamePattern>${LOGS_DIR}/${FILE_NAME}.%d{yyyy-MM-dd}_%d{HHmmss,aux}.%i.log.zip</fileNamePattern>
        <maxHistory>30</maxHistory>
        <TimeBasedFileNamingAndTriggeringPolicy class="my.StartupSizeTimeBasedTriggeringPolicy">
            <MaxFileSize>250MB</MaxFileSize> 
        </TimeBasedFileNamingAndTriggeringPolicy>
    </rollingPolicy>
</appender>