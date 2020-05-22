<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
<appender name="console-soapui" class="org.apache.log4j.ConsoleAppender">
    <layout class="org.apache.log4j.PatternLayout">
        <param name="ConversionPattern" value="%d{yyMMdd-HHmmss.SSS} [%t][%-5p] [%c] %m%n" />
    </layout>
</appender>

<logger name="com.eviware">
    <level value="INFO" />
</logger>
<root>
    <level value="ERROR" />
    <appender-ref ref="console-soapui" />
</root>
</log4j:configuration>