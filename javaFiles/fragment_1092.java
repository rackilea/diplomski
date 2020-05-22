<appender name="applog" class="org.apache.log4j.DailyRollingFileAppender">
        <param name="File" value="${path}/app_${hostName}.${currentDate}.log" />
        <param name="MaxFileSize" value="1MB" />
        <param name="DatePattern" value=".dd-MM-yyyy" />
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="[%d{dd-MM-yyyy HH:mm:ss}] [%-5p] %m%n"/>
        </layout>
</appender>