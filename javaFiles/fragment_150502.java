$ curl -X GET -d '{"begin":22, "end":33}' --trace-ascii - http://localhost:8080/
== Info: About to connect() to localhost port 8080 (#0)
== Info:   Trying ::1... == Info: connected
== Info: Connected to localhost (::1) port 8080 (#0)
=> Send header, 238 bytes (0xee)
0000: GET / HTTP/1.1
0010: User-Agent: curl/7.19.7 (x86_64-redhat-linux-gnu) libcurl/7.19.7
0050:  NSS/3.14.3.0 zlib/1.2.3 libidn/1.18 libssh2/1.4.2
0084: Host: localhost:8080
009a: Accept: */*
00a7: Content-Length: 22
00bb: Content-Type: application/x-www-form-urlencoded
00ec:
=> Send data, 22 bytes (0x16)
0000: {"begin":22, "end":33}