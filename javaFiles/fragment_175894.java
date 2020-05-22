Executing request GET https://www.wikipedia.org/
2020-02-06 10:33:22,619 DEBUG ex-00000001: preparing request execution
2020-02-06 10:33:22,625 DEBUG Cookie spec selected: strict
2020-02-06 10:33:22,629 DEBUG Auth cache not set in the context
2020-02-06 10:33:22,629 DEBUG ex-00000001: target auth state: UNCHALLENGED
2020-02-06 10:33:22,630 DEBUG ex-00000001: proxy auth state: UNCHALLENGED
2020-02-06 10:33:22,630 DEBUG ex-00000001: acquiring connection with route {s}->https://www.wikipedia.org:443
2020-02-06 10:33:22,630 DEBUG ex-00000001: acquiring endpoint (3 MINUTES)
2020-02-06 10:33:22,632 DEBUG ex-00000001: endpoint lease request (3 MINUTES) [route: {s}->https://www.wikipedia.org:443][total available: 0; route allocated: 0 of 5; total allocated: 0 of 25]
2020-02-06 10:33:22,636 DEBUG ex-00000001: endpoint leased [route: {s}->https://www.wikipedia.org:443][total available: 0; route allocated: 1 of 5; total allocated: 1 of 25]
2020-02-06 10:33:22,649 DEBUG ex-00000001: acquired ep-00000000
2020-02-06 10:33:22,649 DEBUG ex-00000001: acquired endpoint ep-00000000
2020-02-06 10:33:22,649 DEBUG ex-00000001: opening connection {s}->https://www.wikipedia.org:443
2020-02-06 10:33:22,650 DEBUG ep-00000000: connecting endpoint (3 MINUTES)
2020-02-06 10:33:22,650 DEBUG ep-00000000: connecting endpoint to https://www.wikipedia.org:443 (3 MINUTES)
2020-02-06 10:33:22,654 DEBUG http-outgoing-0: connecting to www.wikipedia.org/91.198.174.192:443
2020-02-06 10:33:22,654 DEBUG Connecting socket to www.wikipedia.org/91.198.174.192:443 with timeout 3 MINUTES
2020-02-06 10:33:22,759 DEBUG Enabled protocols: [TLSv1.2, TLSv1.3]
2020-02-06 10:33:22,759 DEBUG Enabled cipher suites:[TLS_AES_128_GCM_SHA256, TLS_AES_256_GCM_SHA384, TLS_CHACHA20_POLY1305_SHA256, TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, TLS_RSA_WITH_AES_128_GCM_SHA256, TLS_RSA_WITH_AES_256_GCM_SHA384, TLS_RSA_WITH_AES_128_CBC_SHA, TLS_RSA_WITH_AES_256_CBC_SHA, TLS_EMPTY_RENEGOTIATION_INFO_SCSV]
2020-02-06 10:33:22,759 DEBUG Starting handshake
2020-02-06 10:33:23,192 DEBUG Secure session established
2020-02-06 10:33:23,192 DEBUG  negotiated protocol: TLSv1.2
2020-02-06 10:33:23,192 DEBUG  negotiated cipher suite: TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256
2020-02-06 10:33:23,192 DEBUG  peer principal: CN=*.wikipedia.org, O="Wikimedia Foundation, Inc.", L=San Francisco, ST=California, C=US
2020-02-06 10:33:23,193 DEBUG  peer alternative names: [*.wikipedia.org, *.wikimedia.org, *.wmfusercontent.org, *.wikimediafoundation.org, *.wiktionary.org, *.wikivoyage.org, *.wikiversity.org, *.wikisource.org, *.wikiquote.org, *.wikinews.org, *.wikidata.org, *.wikibooks.org, wikimedia.org, *.mediawiki.org, wikipedia.org, wikiquote.org, mediawiki.org, wmfusercontent.org, w.wiki, wikimediafoundation.org, wikibooks.org, wiktionary.org, wikivoyage.org, wikidata.org, wikiversity.org, wikisource.org, wikinews.org, *.m.wikipedia.org, *.m.wiktionary.org, *.m.wikivoyage.org, *.m.wikiquote.org, *.m.wikiversity.org, *.m.wikisource.org, *.m.wikimedia.org, *.m.wikinews.org, *.m.wikidata.org, *.m.wikibooks.org, *.planet.wikimedia.org, *.m.mediawiki.org]
2020-02-06 10:33:23,193 DEBUG  issuer principal: CN=DigiCert SHA2 High Assurance Server CA, OU=www.digicert.com, O=DigiCert Inc, C=US
2020-02-06 10:33:23,196 DEBUG http-outgoing-0: connection established 192.168.43.143:55022<->91.198.174.192:443
2020-02-06 10:33:23,196 DEBUG ep-00000000: connected http-outgoing-0
2020-02-06 10:33:23,196 DEBUG ep-00000000: endpoint connected
2020-02-06 10:33:23,197 DEBUG ex-00000001: executing GET / HTTP/1.1
2020-02-06 10:33:23,197 DEBUG ep-00000000: start execution ex-00000001
2020-02-06 10:33:23,197 DEBUG ep-00000000: executing exchange ex-00000001 over http-outgoing-0
2020-02-06 10:33:23,198 DEBUG http-outgoing-0 >> GET / HTTP/1.1
2020-02-06 10:33:23,198 DEBUG http-outgoing-0 >> Accept-Encoding: gzip, x-gzip, deflate
2020-02-06 10:33:23,198 DEBUG http-outgoing-0 >> Host: www.wikipedia.org
2020-02-06 10:33:23,198 DEBUG http-outgoing-0 >> Connection: keep-alive
2020-02-06 10:33:23,198 DEBUG http-outgoing-0 >> User-Agent: Apache-HttpClient/5.0-beta8-SNAPSHOT (Java/1.8.0_181)
2020-02-06 10:33:23,402 DEBUG http-outgoing-0 << HTTP/1.1 200 OK
2020-02-06 10:33:23,403 DEBUG http-outgoing-0 << Date: Wed, 05 Feb 2020 20:39:26 GMT
2020-02-06 10:33:23,403 DEBUG http-outgoing-0 << Cache-Control: s-maxage=86400, must-revalidate, max-age=3600
2020-02-06 10:33:23,403 DEBUG http-outgoing-0 << Server: ATS/8.0.5
2020-02-06 10:33:23,404 DEBUG http-outgoing-0 << X-ATS-Timestamp: 1580935166
2020-02-06 10:33:23,404 DEBUG http-outgoing-0 << ETag: W/"12be8-59c0633ed3519"
2020-02-06 10:33:23,404 DEBUG http-outgoing-0 << Content-Type: text/html
2020-02-06 10:33:23,404 DEBUG http-outgoing-0 << Last-Modified: Mon, 13 Jan 2020 14:22:18 GMT
2020-02-06 10:33:23,405 DEBUG http-outgoing-0 << Backend-Timing: D=320 t=1579084179579408
2020-02-06 10:33:23,405 DEBUG http-outgoing-0 << Content-Encoding: gzip
2020-02-06 10:33:23,405 DEBUG http-outgoing-0 << Vary: Accept-Encoding
2020-02-06 10:33:23,405 DEBUG http-outgoing-0 << X-Varnish: 118503554 495852195
2020-02-06 10:33:23,406 DEBUG http-outgoing-0 << Age: 46437
2020-02-06 10:33:23,406 DEBUG http-outgoing-0 << X-Cache: cp3062 miss, cp3052 hit/600912
2020-02-06 10:33:23,406 DEBUG http-outgoing-0 << X-Cache-Status: hit-front
2020-02-06 10:33:23,407 DEBUG http-outgoing-0 << Server-Timing: cache;desc="hit-front"
2020-02-06 10:33:23,407 DEBUG http-outgoing-0 << Strict-Transport-Security: max-age=106384710; includeSubDomains; preload
2020-02-06 10:33:23,407 DEBUG http-outgoing-0 << Set-Cookie: WMF-Last-Access=06-Feb-2020;Path=/;HttpOnly;secure;Expires=Mon, 09 Mar 2020 00:00:00 GMT
2020-02-06 10:33:23,407 DEBUG http-outgoing-0 << Set-Cookie: WMF-Last-Access-Global=06-Feb-2020;Path=/;Domain=.wikipedia.org;HttpOnly;secure;Expires=Mon, 09 Mar 2020 00:00:00 GMT
2020-02-06 10:33:23,408 DEBUG http-outgoing-0 << X-Client-IP: 213.55.225.99
2020-02-06 10:33:23,418 DEBUG http-outgoing-0 << Set-Cookie: GeoIP=CH:ZH:Zurich:47.37:8.55:v4; Path=/; secure; Domain=.wikipedia.org
2020-02-06 10:33:23,418 DEBUG http-outgoing-0 << Accept-Ranges: bytes
2020-02-06 10:33:23,418 DEBUG http-outgoing-0 << Content-Length: 18800
2020-02-06 10:33:23,419 DEBUG http-outgoing-0 << Connection: keep-alive
2020-02-06 10:33:23,429 DEBUG ex-00000001: connection can be kept alive for -1 MILLISECONDS
2020-02-06 10:33:23,437 DEBUG Cookie accepted [WMF-Last-Access="06-Feb-2020", domain:www.wikipedia.org, path:/, expiry:Mon Mar 09 01:00:00 CET 2020]
2020-02-06 10:33:23,438 DEBUG Cookie accepted [WMF-Last-Access-Global="06-Feb-2020", domain:wikipedia.org, path:/, expiry:Mon Mar 09 01:00:00 CET 2020]
2020-02-06 10:33:23,438 DEBUG Cookie accepted [GeoIP="CH:ZH:Zurich:47.37:8.55:v4", domain:wikipedia.org, path:/, expiry:null]
----------------------------------------
200 OK
SSL protocol TLSv1.2
SSL cipher suite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256
2020-02-06 10:33:23,467 DEBUG http-outgoing-0: close connection GRACEFUL
2020-02-06 10:33:23,468 DEBUG ep-00000000: endpoint closed
2020-02-06 10:33:23,468 DEBUG ep-00000000: endpoint closed
2020-02-06 10:33:23,468 DEBUG ep-00000000: discarding endpoint
2020-02-06 10:33:23,468 DEBUG ep-00000000: releasing endpoint
2020-02-06 10:33:23,469 DEBUG ep-00000000: connection released [route: {s}->https://www.wikipedia.org:443][total available: 0; route allocated: 0 of 5; total allocated: 0 of 25]
2020-02-06 10:33:23,469 DEBUG Shutdown connection pool GRACEFUL
2020-02-06 10:33:23,469 DEBUG Connection pool shut down