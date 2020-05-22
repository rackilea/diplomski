C:\Users\abhishek>curl -i "http://localhost:8151/userx/clientres/hello"
HTTP/1.1 200 OK
Content-type: text/plain; charset=UTF-8
Content-length: 12
Server: Restlet-Framework/2.3.9
Accept-ranges: bytes
Vary: Accept-Charset, Accept-Encoding, Accept-Language, Accept
Date: Mon, 23 Jan 2017 11:37:01 GMT

Hello Client

======================================================================

C:\Users\abhishek>curl -i -H "Authorization: Basic c2NvdHQ6dGlnZXI=" "http://localhost:8151/admin/accounts/abc123"
HTTP/1.1 200 OK
Content-type: text/plain; charset=UTF-8
Content-length: 35
Server: Restlet-Framework/2.3.9
Accept-ranges: bytes
Vary: Accept-Charset, Accept-Encoding, Accept-Language, Accept
Date: Mon, 23 Jan 2017 11:35:07 GMT

please enter a sub-url after abc123

======================================================================

C:\Users\abhishek>curl -i -H "Authorization: Basic c2NvdHQ6dGlnZXI=" "http://localhost:8151/admin/accounts/abc123/user"
HTTP/1.1 200 OK
Content-type: text/plain; charset=UTF-8
Content-length: 11
Server: Restlet-Framework/2.3.9
Accept-ranges: bytes
Vary: Accept-Charset, Accept-Encoding, Accept-Language, Accept
Date: Mon, 23 Jan 2017 11:35:04 GMT

Hello Admin

======================================================================

C:\Users\abhishek>curl -i "http://localhost:8151/admin/accounts/abc123/user"
HTTP/1.1 401 Unauthorized
Content-type: text/html; charset=UTF-8
Content-length: 424
Www-authenticate: Basic realm="Example site"
Server: Restlet-Framework/2.3.9
Accept-ranges: bytes
Date: Mon, 23 Jan 2017 12:48:08 GMT

<html>
<head>
   <title>Status page</title>
</head>
<body style="font-family: sans-serif;">
<p style="font-size: 1.2em;font-weight: bold;margin: 1em 0px;">Unauthorized</p>
<p>The request requires user authentication</p>
<p>You can get technical details <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.2">here</a>.<br>
Please continue your visit at our <a href="/">home page</a>.
</p>
</body>
</html>