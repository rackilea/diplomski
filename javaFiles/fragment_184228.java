<testng classpath="class file path" suitename="suite1"
    outputDir="test output"    
    haltonfailure="true"
    useDefaultListeners="false"
    listeners="org.uncommons.reportng.HTMLReporter,org.uncommons.reportng.JUnitXMLReporter"
    >   
        <xmlfileset dir="${ws.home}" includes="testng.xml"/>
        <sysproperty key="org.uncommons.reportng.title" value="Report"/>    
    </testng>