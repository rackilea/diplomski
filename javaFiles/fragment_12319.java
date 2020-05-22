<appender name="AUDIT_LOG" class="ch.qos.logback.core.rolling.RollingFileAppender">
    <!-- this filter will accept all log events having the logger name "classname" -->
    <filter class="ch.qos.logback.core.filter.EvaluatorFilter">
        <evaluator>
            <expression>return logger.equals("classname");</expression>
        </evaluator>
        <OnMismatch>DENY</OnMismatch>
        <OnMatch>NEUTRAL</OnMatch>
    </filter>

    <file>${LOG_PATH}/audit/audit.log</file>
    <rollingPolicy class="ch.qos.logback.core.rolling.FixedWindowRollingPolicy">
        <fileNamePattern>${LOG_PATH}/audit/audit.%i.log.gz</fileNamePattern>
        <minIndex>1</minIndex>
        <maxIndex>10</maxIndex>
    </rollingPolicy>
    <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
        <maxFileSize>10MB</maxFileSize>
    </triggeringPolicy>
    <encoder>
        <charset>utf-8</charset>
        <Pattern>${FILE_LOG_PATTERN}</Pattern>
    </encoder>
</appender>