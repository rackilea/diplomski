C:\temp\jboss\quickstart\helloworld-rs>curl 
                         -v http://localhost:8080/wildfly-helloworld-rs/rest/ 
                         -H 'accept:application/xml'
* Adding handle: conn: 0x4b6208
* Adding handle: send: 0
* Adding handle: recv: 0
* Curl_addHandleToPipeline: length: 1
* - Conn 0 (0x4b6208) send_pipe: 1, recv_pipe: 0
* About to connect() to localhost port 8080 (#0)
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /wildfly-helloworld-rs/rest/ HTTP/1.1
> User-Agent: curl/7.30.0
> Host: localhost:8080
> Accept: */*
> 'accept:application/xml'
>
< HTTP/1.1 200 OK
< Connection: keep-alive
< X-Powered-By: Undertow/1
* Server WildFly/8 is not blacklisted
< Server: WildFly/8
< Content-Type: application/json
< Content-Length: 25
< Date: Sun, 23 Nov 2014 03:00:56 GMT
<
{"result":"Hello World!"}* Connection #0 to host localhost left intact

C:\temp\jboss\quickstart\helloworld-rs>