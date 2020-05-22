<configuration> 
    <appender name="savingAppender" class="SavingAppender"> 
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="outputError" class="ch.qos.logback.core.ConsoleAppender">
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter"> 
            <level>error</level>
        </filter>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <appender name="incidentAppender" class="ch.qos.logback.core.FileAppender">
        <file>output.log</file>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="info">
        <appender-ref ref="savingAppender"/>
        <appender-ref ref="outputError"/>
    </root>

    <logger name="incident">
        <appender-ref ref="incidentAppender"/>
    </logger>
</configuration>