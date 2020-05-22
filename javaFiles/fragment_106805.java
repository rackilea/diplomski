<http:outbound-gateway request-channel="requestChannel"
    url-expression="'${bir.xml.url}' + payload.toString()" http-method="GET"
    extract-request-payload="true" expected-response-type="java.lang.String"
    charset="UTF-8" reply-timeout="30000" reply-channel="dtdRemovingTransformerChannel"
    message-converters="stringHttpMessageConverter"
    mapped-response-headers="Date, Server, Pragma, Cache-Control, SVRID, last-modified">
</http:outbound-gateway>