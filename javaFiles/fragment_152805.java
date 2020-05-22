<!-- A HTTP/1.1 Connector on port 8081 -->
<Connector protocol="HTTP/1.1" port="8081" address="${jboss.bind.address}" 
   redirectPort="${jboss.web.https.port}" />

<!-- A HTTP/1.1 Connector on port 8082 -->
<Connector protocol="HTTP/1.1" port="8082" address="${jboss.bind.address}" 
   redirectPort="${jboss.web.https.port}" />