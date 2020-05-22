<Routing name="ConferenceLog">
    <Routes pattern="${ctx:logFileName}">
        <Route>
            <RollingFile name="Rolling-${ctx:logFileName}"
                fileName="${LOG_DIR}/conferences/${ctx:logFileName}.log"
                filePattern="${LOG_DIR}/conferences/${ctx:logFileName}.%i.log.gz">
                <PatternLayout pattern="${PATTERN}" />
                <SizeBasedTriggeringPolicy size="20971520" />
            </RollingFile>
        </Route>
    </Routes>
    <IdlePurgePolicy timeToLive="30" timeUnit="seconds"/>
</Routing>