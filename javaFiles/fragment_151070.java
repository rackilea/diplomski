<route>
        <from uri="timer:aTimer?fixedRate=true&amp;period=60s"/>
        <setHeader headerName="CamelHttpMethod">
            <constant>GET</constant>
        </setHeader>
        <to uri="http4://foo.com/api/dosomething"/>
        <unmarshall ref="json"/>
        <to uri="bean:aDomainPojo"/>
        <to uri="log:com.foocorps.demonstrations?level=INFO"/>
        <log message="{$body}"/>
    </route>

    <dataFormats>
        <json id="json" library="Jackson"/>
    </dataFormats>