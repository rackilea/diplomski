<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="ch.qos.logback.core.encoder.LayoutWrappingEncoder">
            <layout class="my.package.logging.GCPCloudLoggingJSONLayout">
                <pattern>%-4relative [%thread] %-5level %logger{35} - %msg</pattern>
            </layout>
        </encoder>
    </appender>
    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>