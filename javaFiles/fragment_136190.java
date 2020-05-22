<camelContext xmlns="http://camel.apache.org/schema/blueprint">
    <route id="timerToLog">
        <from uri="restlet:http://localhost:7070/arena?restletMethod=POST&amp;exchangePattern=inOnly"/>
        <wireTap uri="direct:tap" copy="true"></wireTap>
        <transform>
            <constant>OK</constant>
        </transform>
    </route>

    <route id="wireTapToLog">
        <from uri="direct:tap"/>
        <process ref="marcformatreader"/>
        <log message="${body}" loggingLevel="INFO"/>
        <process ref="marcformatwriter"/>
        <log message="${body}" loggingLevel="INFO"/>
        <to pattern="InOnly" uri="file:C:/Camel/output?fileName=output.mrc"/>
    </route>

</camelContext>