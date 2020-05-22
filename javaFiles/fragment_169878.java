<RollingFile name="CATALINA"
                 fileName   ="${sys:catalina.base}/logs/catalina.${date:yyyy-MM-dd}.log"
                 filePattern="${sys:catalina.base}/logs/catalina.%d{yyyy-MM-dd}.log">
        <PatternLayout pattern="[TID=%tid] %d %-5p %c- %m%n"/>
        <TimeBasedTriggeringPolicy modulate="true" />
    </RollingFile>