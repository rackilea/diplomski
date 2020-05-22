<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
<appender name="console-apache" class="org.apache.log4j.ConsoleAppender">
    <layout class="org.apache.log4j.PatternLayout">
        <param name="ConversionPattern" value="%d{yyMMdd-HHmmss.SSS} [%t][%-5p] [%c] %m%n" />
    </layout>
</appender>

<logger name="org.apache">
    <level value="ERROR" />
</logger>
<root>
    <level value="ERROR" />
    <appender-ref ref="console-apache" />
</root>
</log4j:configuration>