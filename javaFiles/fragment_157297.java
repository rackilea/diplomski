<route id="createentityattachment" streamCache="true">
        <from uri="restlet:/EntityAttachments?restletMethod=POST&amp;restletBinding=#queryStringToHeadersRestletBinding"/>
        <removeHeaders excludePattern="X-eviCore-EntityAttachments*" pattern="^(Camel|Backbase|User-|Accept|Cache|Cookie|breadcrumbId|Host|Connection|DNT|Upgrade-Insecure-Requests|org.restlet.startTime).*$"/>
        <setHeader headerName="CamelHttpMethod">
            <constant>POST</constant>
        </setHeader>
        <to uri="http4://api.innovate.lan:8280/entityattachments/1.0.0.0/api/v1/EntityAttachments"/>
</route>