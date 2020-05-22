<appender name="DIAGAPPDENDER" class="org.apache.log4j.RollingFileAppender"> 
    <param name="File" value="${rpt.trace}/diagnostic.log"/>
</appender> 

<appender name="ROOTAPPENDER" class="org.apache.log4j.ConsoleAppender">
    <layout class="org.apache.log4j.PatternLayout"> 
    <param name="Threshold" value="WARN" /> 
</appender>

<logger name="rpt.diagnostic">
    <level value ="ALL" />
    <appender-ref ref="DIAGAPPDENDER"/> 
</logger>

<root>
    <priority value ="WARN" />
    <appender-ref ref="ROOTAPPENDER" /> 
</root>