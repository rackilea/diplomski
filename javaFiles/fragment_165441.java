<RollingFile name="RollingFile" 
             fileName="/tmp/app.log"
             filePattern="/tmp/app%d{yyyy-MM-dd}.log">
    <PatternLayout pattern="%d %p %c{1.} [%t] %m%n" />
    <TimeBasedTriggeringPolicy />
</RollingFile>