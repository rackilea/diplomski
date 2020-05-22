POST https://10.88.131.141:8443/axl/ HTTP/1.1
Accept-Encoding: gzip,deflate
Content-Type: text/xml;charset=UTF-8
SOAPAction: "CUCM B ver=8.5 doAuthenticateUser"
User-Agent: Jakarta Commons-HttpClient/3.1
Content-Length: 444
Authorization: Basic QWRtaW5pc3RyYXRvcjpjaXNjbyExMjM=
Host: 10.88.131.141:8443



<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns="http://www.cisco.com/AXL/API/8.5">
   <soapenv:Header/>
   <soapenv:Body>
      <ns:doAuthenticateUser sequence="1">
         <userid>cupuser1</userid>
         <!--You have a CHOICE of the next 2 items at this level-->
         <password>password</password>
<!--         <pin>?</pin> -->
      </ns:doAuthenticateUser>
   </soapenv:Body>
</soapenv:Envelope>