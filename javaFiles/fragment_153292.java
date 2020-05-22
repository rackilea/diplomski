<Appenders>
    <!-- STDOUT appender. -->
    <Console name="Console" target="SYSTEM_OUT">
        <PatternLayout
            pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36}#%M - %msg%n" />
    </Console>

    <RollingRandomAccessFile name="MyOriginalFileAppender" fileName="${baseDir}/${defaultLogName}.log" filePattern="${baseDir}/$${date:yyyy-MM}/${defaultLogName}-%d{MM-dd-yyyy}.%i.log.gz">
        <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36}#%M - %msg%n" />
        <Policies>
            <!-- <TimeBasedTriggeringPolicy /> -->
            <!-- Let's try cron triggering policy configured to trigger every day at midnight -->
            <CronTriggeringPolicy schedule="0 0 0 * * ?"/>
            <SizeBasedTriggeringPolicy size="25 MB" />
        </Policies>
    </RollingRandomAccessFile>
</Appenders>
<Loggers>
    <Root level="debug">
        <!-- only write INFO level to the file. -->
        <AppenderRef ref="MyOriginalFileAppender" level="debug"/>
        <!-- Console shows everything at DEBUG level-->
        <AppenderRef ref="Console" level="info" />
    </Root>
</Loggers>