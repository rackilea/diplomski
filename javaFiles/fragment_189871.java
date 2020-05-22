@Component
public class LogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        if (request.getServletPath().contains("healthcheck")) {
            try (CloseableThreadContext.Instance context = CloseableThreadContext.put("health", "true")) {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }
}

<Configuration status="WARN" monitorInterval="30">
    <Appenders>
        <Console name="CONSOLE" target="SYSTEM_OUT" follow="true">
            <PatternLayout
                    pattern="%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}} %highlight{${LOG_LEVEL_PATTERN:-%5p}}{FATAL=red blink, ERROR=red, WARN=yellow, INFO=green, DEBUG=blue, TRACE=white} %style{${sys:PID}}{magenta} [%15.15t] %style{%-40.40C{1.}}{cyan} : %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}"/>
        </Console>
        <Routing name="ROUTING">
            <Routes pattern="$${ctx:health}">
                <Route key="true">
                    <RollingRandomAccessFile name="FILE_HEALTH"
                                             fileName="logs/reference-service-health.log"
                                             filePattern="logs/reference-service-health.log.%d{yyyy-MM-dd-hh-mm}.gz">
                        <PatternLayout pattern="[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n"/>
                        <Policies>
                            <SizeBasedTriggeringPolicy size="1024 KB"/>
                        </Policies>
                        <DefaultRolloverStrategy max="30"/>
                    </RollingRandomAccessFile>
                </Route>
                <Route>
                    <RollingRandomAccessFile name="FILE"
                                             fileName="logs/reference-service.log"
                                             filePattern="logs/reference-service.log.%d{yyyy-MM-dd-hh-mm}.gz">
                        <PatternLayout pattern="[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n"/>
                        <Policies>
                            <SizeBasedTriggeringPolicy size="1024 KB"/>
                        </Policies>
                        <DefaultRolloverStrategy max="30"/>
                    </RollingRandomAccessFile>
                </Route>
            </Routes>
        </Routing>
    </Appenders>
    <Loggers>
        <Logger name="org.hibernate" level="info" additivity="false">
            <AppenderRef ref="CONSOLE"/>
            <AppenderRef ref="ROUTING"/>
        </Logger>
        <Logger name="org.springframework" level="info" additivity="false">
            <AppenderRef ref="CONSOLE"/>
            <AppenderRef ref="ROUTING"/>
        </Logger>
        <Root level="debug" additivity="false">
            <AppenderRef ref="CONSOLE"/>
            <AppenderRef ref="ROUTING"/>
        </Root>
    </Loggers>
</Configuration>