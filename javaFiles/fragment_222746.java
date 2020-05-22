curl "Accept: application/json" -H 'If-Match: "somevalue"' -i http://localhost:8080/rest-sec/api/resources/1

HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
ETag: "03cb37ca667706c68c0aad4cb04c3a211"
Content-Type: application/json;charset=UTF-8
Content-Length: 56
Date: Fri, 11 Jan 2013 14:58:40 GMT