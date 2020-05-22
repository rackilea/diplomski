<subsystem xmlns="urn:jboss:domain:logging:1.1">
...
    <periodic-rotating-file-handler name="GENERAL_LOGGER_handler">
        <formatter>
            <pattern-formatter pattern="%d{HH:mm:ss,SSS} %-5p [%c] (%t) %s%E%n"/>
        </formatter>
        <file relative-to="jboss.server.log.dir" path="GENERAL_LOGGER_APP.LOG"/>
        <suffix value=".yyyy-MM-dd"/>
        <append value="true"/>
    </periodic-rotating-file-handler>
    <logger category="GENERAL_LOGGER">
        <level name="DEBUG"/>
        <handlers>
            <handler name="GENERAL_LOGGER_handler"/>
        </handlers>
    </logger>
...