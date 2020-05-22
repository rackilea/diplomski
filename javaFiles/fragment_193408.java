$ curl -v http://localhost:8080/file
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /file HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.47.0
> Accept: */*
> 
< HTTP/1.1 200 OK
< Date: Wed, 11 Apr 2018 14:15:06 GMT
< Content-Disposition: attachment; filename="file.txt"
< Content-Type: application/octet-stream
< Vary: Accept-Encoding
< Content-Length: 12
< 
foo
bar
baz