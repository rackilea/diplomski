2015-06-25 14:18:19.186:INFO::main: Logging initialized @167ms
2015-06-25 14:18:19.241:INFO:oejs.Server:main: jetty-9.3.0.v20150612
2015-06-25 14:18:19.276:INFO:oejsh.ContextHandler:main: Started o.e.j.s.ServletContextHandler@56cbfb61{/,null,AVAILABLE}
2015-06-25 14:18:19.288:INFO:oejs.ServerConnector:main: Started ServerConnector@1ef05443{HTTP/1.1,[http/1.1]}{0.0.0.0:9090}
2015-06-25 14:18:19.289:INFO:oejs.Server:main: Started @270ms
HTTP/1.1 200 OK
Date: Thu, 25 Jun 2015 21:18:19 GMT
Content-Type: text/plain;charset=iso-8859-1
Set-Cookie: SID=31d4d96e407aad42;Path=/;Secure;HttpOnly
Expires: Thu, 01 Jan 1970 00:00:00 GMT
Set-Cookie: lang=en-US;Path=/;Domain=example.com
Connection: close
Server: Jetty(9.3.0.v20150612)

Hello From: jetty.SetCookieTest$SetCookieAddCookieServlet

HTTP/1.1 200 OK
Date: Thu, 25 Jun 2015 21:18:19 GMT
Content-Type: text/plain;charset=iso-8859-1
Set-Cookie: SID=31d4d96e407aad42; Path=/; Secure; HttpOnly
Set-Cookie: lang=en-US; Path=/; Domain=example.com
Connection: close
Server: Jetty(9.3.0.v20150612)

Hello From: jetty.SetCookieTest$SetCookieAddHeaderServlet

2015-06-25 14:18:19.405:INFO:oejs.ServerConnector:main: Stopped ServerConnector@1ef05443{HTTP/1.1,[http/1.1]}{0.0.0.0:9090}
2015-06-25 14:18:19.407:INFO:oejsh.ContextHandler:main: Stopped o.e.j.s.ServletContextHandler@56cbfb61{/,null,UNAVAILABLE}