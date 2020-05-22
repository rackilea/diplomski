[DEBUG] ProtocolExec - Unable to parse 'all kind of c%.p' as a valid URI; request URI and Host header may be inconsistent <java.lang.IllegalArgumentException: Illegal character in path at index 3: all kind of c%.p>java.lang.IllegalArgumentException: Illegal character in path at index 3: all kind of c%.p
    at java.net.URI.create(URI.java:852)
    at org.apache.http.impl.execchain.ProtocolExec.execute(ProtocolExec.java:120)
    at org.apache.http.impl.execchain.RetryExec.execute(RetryExec.java:89)
    at org.apache.http.impl.execchain.RedirectExec.execute(RedirectExec.java:111)
    at org.apache.http.impl.client.InternalHttpClient.doExecute(InternalHttpClient.java:185)
    at org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:118)
    at Testing.main(Testing.java:15)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
Caused by: java.net.URISyntaxException: Illegal character in path at index 3: all kind of c%.p
    at java.net.URI$Parser.fail(URI.java:2848)
    at java.net.URI$Parser.checkChars(URI.java:3021)
    at java.net.URI$Parser.parseHierarchical(URI.java:3105)
    at java.net.URI$Parser.parse(URI.java:3063)
    at java.net.URI.<init>(URI.java:588)
    at java.net.URI.create(URI.java:850)
    ... 11 more

[DEBUG] RequestAddCookies - CookieSpec selected: default
[DEBUG] RequestAuthCache - Auth cache not set in the context
[DEBUG] PoolingHttpClientConnectionManager - Connection request: [route: {}->http://www.google.com:80][total kept alive: 0; route allocated: 0 of 2; total allocated: 0 of 20]
[DEBUG] PoolingHttpClientConnectionManager - Connection leased: [id: 0][route: {}->http://www.google.com:80][total kept alive: 0; route allocated: 1 of 2; total allocated: 1 of 20]
[DEBUG] MainClientExec - Opening connection {}->http://www.google.com:80
[DEBUG] DefaultHttpClientConnectionOperator - Connecting to www.google.com/216.58.213.100:80
[DEBUG] DefaultHttpClientConnectionOperator - Connection established xx.xx.xx.xx:36088<->216.58.213.100:80
[DEBUG] MainClientExec - Executing request GET all kind of c%.p HTTP/1.1
[DEBUG] MainClientExec - Target auth state: UNCHALLENGED
[DEBUG] MainClientExec - Proxy auth state: UNCHALLENGED
[DEBUG] headers - http-outgoing-0 >> GET all kind of c%.p HTTP/1.1
[DEBUG] headers - http-outgoing-0 >> Host: www.google.com
[DEBUG] headers - http-outgoing-0 >> Connection: Keep-Alive
[DEBUG] headers - http-outgoing-0 >> User-Agent: Apache-HttpClient/4.5.3 (Java/1.8.0_112)
[DEBUG] headers - http-outgoing-0 >> Accept-Encoding: gzip,deflate
[DEBUG] headers - http-outgoing-0 << HTTP/1.1 400 Bad Request
[DEBUG] headers - http-outgoing-0 << Cache-Control: no-cache
[DEBUG] headers - http-outgoing-0 << Pragma: no-cache
[DEBUG] headers - http-outgoing-0 << Content-Type: text/html; charset=utf-8
[DEBUG] headers - http-outgoing-0 << Connection: close
[DEBUG] headers - http-outgoing-0 << Content-Length: 1904
HTTP/1.1 400 Bad Request
[DEBUG] DefaultManagedHttpClientConnection - http-outgoing-0: Close connection
[DEBUG] MainClientExec - Connection discarded
[DEBUG] PoolingHttpClientConnectionManager - Connection released: [id: 0][route: {}->http://www.google.com:80][total kept alive: 0; route allocated: 0 of 2; total allocated: 0 of 20]