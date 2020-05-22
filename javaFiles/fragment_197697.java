<route>
        <from uri="restlet:http://0.0.0.0:8081/nextbus/{agency}/{command}" />
        <setHeader headerName="CamelHttpMethod">
            <constant>GET</constant>
        </setHeader>
        <removeHeader headerName="CamelHttpUri" />
        <recipientList>
            <simple>http://webservices.nextbus.com/service/publicXMLFeed?command=${header.command}&amp;a=${header.agency}</simple>
        </recipientList>            
</route>