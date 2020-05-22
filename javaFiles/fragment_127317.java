<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
        <pattern>%d{HH:mm:ss.SSS} %coloredLevel %cyan(%logger{15}) %message%n%xException{5}</pattern>
    </encoder>
</appender>

<appender name="STDOUTERR" class="ch.qos.logback.core.ConsoleAppender">

    <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
        <level>WARN</level>
    </filter>

    <encoder>
        <pattern>%d{HH:mm:ss.SSS} %coloredLevel %cyan(%logger{15}) %message%n%xException{5}</pattern>
    </encoder>
</appender>