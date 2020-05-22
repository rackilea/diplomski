$ curl -I http://localhost:8080/test
HTTP/1.1 421
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: SAMEORIGIN
Content-Type: text/plain
Content-Length: 11
Date: Tue, 03 Sep 2019 12:23:58 GMT