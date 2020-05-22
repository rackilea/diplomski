$ clear; curl -v http://localhost:8080/
* About to connect() to localhost port 8080 (#0)
*   Trying 127.0.0.1...
* 0x60002d0f0 is at send pipe head!
* STATE: CONNECT => WAITCONNECT handle 0x60006cac0; line 1032 (connection #0)
* Connected to localhost (127.0.0.1) port 8080 (#0)
* STATE: WAITCONNECT => DO handle 0x60006cac0; line 1151 (connection #0)
> GET / HTTP/1.1
> User-Agent: curl/7.29.0
> Host: localhost:8080
> Accept: */*
>
* STATE: DO => DO_DONE handle 0x60006cac0; line 1236 (connection #0)
* STATE: DO_DONE => WAITPERFORM handle 0x60006cac0; line 1352 (connection #0)
* STATE: WAITPERFORM => PERFORM handle 0x60006cac0; line 1363 (connection #0)
* HTTP 1.1 or later with persistent connection, pipelining supported
< HTTP/1.1 200 OK
HTTP/1.1 200 OK
< Server: Apache-Coyote/1.1
Server: Apache-Coyote/1.1
< Set-Cookie: JSESSIONID=7694BACEC0C311357E72DCEA7574540A; Path=/; HttpOnly
Set-Cookie: JSESSIONID=7694BACEC0C311357E72DCEA7574540A; Path=/; HttpOnly
< Content-Type: text/html;charset=ISO-8859-1
Content-Type: text/html;charset=ISO-8859-1
< Content-Length: 12
Content-Length: 12
< Date: Mon, 02 Sep 2013 16:40:11 GMT
Date: Mon, 02 Sep 2013 16:40:11 GMT

<
* STATE: PERFORM => DONE handle 0x60006cac0; line 1533 (connection #0)
* Connection #0 to host localhost left intact
host printed