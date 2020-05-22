<appenders>
    <appender name="applicationAppender" type="RollingFile" fileName="${logFileName}" filePattern="${logFileNamePattern}" bufferedIO="true" immediateFlush="true" append="true">
        <layout type="PatternLayout" pattern="${logPattern}" />
        <Policies>
            <TimeBasedTriggeringPolicy />
            <SizeBasedTriggeringPolicy size="${logFileSize}" />
        </Policies>
        <DefaultRolloverStrategy max="${logFileCount}" />
    </appender>

    <Routing name="contextSpecificAppender">
        <Routes pattern="$${ctx:contextId}">
            <Route>
                <appender name="Rolling-${ctx:contextId}" type="RollingFile" fileName="logs/${ctx:contextId}.log" filePattern="${logFileNamePattern}" bufferedIO="true" immediateFlush="true" append="true">
                    <layout type="PatternLayout" pattern="${logPattern}" />
                    <Policies>
                        <TimeBasedTriggeringPolicy />
                        <SizeBasedTriggeringPolicy size="${logFileSize}" />
                    </Policies>
                    <DefaultRolloverStrategy max="${logFileCount}" />
                </appender>
            </Route>
        </Routes>
    </Routing>
</appenders>

<loggers>
    <root level="info">
        <appender-ref ref="contextSpecificAppender">
            <ThreadContextMapFilter onMatch="DENY" onMismatch="ACCEPT">
                <KeyValuePair key="contextId" value="" />
            </ThreadContextMapFilter>
        </appender-ref>
        <appender-ref ref="applicationAppender">
            <ThreadContextMapFilter onMatch="ACCEPT" onMismatch="DENY">
                <KeyValuePair key="contextId" value="" />
            </ThreadContextMapFilter>
        </appender-ref>
    </root>
</loggers>