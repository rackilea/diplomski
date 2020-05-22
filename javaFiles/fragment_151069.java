<route>
        <from uri="timer:aTimer?fixedRate=true&amp;period=60s"/>
        <setHeader headerName="CamelHttpMethod">
            <constant>GET</constant>
        </setHeader>
        <to uri="cxfrs://bean://bitcoinPriceSvc"/>
        <process ref="itemRetriever"/>
        <to uri="log:com.foocorps.demonstrations?level=INFO"/>
        <log message="{$body}"/>
    </route>