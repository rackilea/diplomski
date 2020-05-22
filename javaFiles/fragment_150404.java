146       /*
147        * Restrict setting of request headers through the public api
148        * consistent with JavaScript XMLHttpRequest2 with a few
149        * exceptions. Disallowed headers are silently ignored for
150        * backwards compatibility reasons rather than throwing a
151        * SecurityException. For example, some applets set the
152        * Host header since old JREs did not implement HTTP 1.1.
153        * Additionally, any header starting with Sec- is
154        * disallowed.
155        *
156        * The following headers are allowed for historical reasons:
157        *
158        * Accept-Charset, Accept-Encoding, Cookie, Cookie2, Date,
159        * Referer, TE, User-Agent, headers beginning with Proxy-.
160        *
161        * The following headers are allowed in a limited form:
162        *
163        * Connection: close
164        *
165        * See http://www.w3.org/TR/XMLHttpRequest2.
166        */
167       private static final boolean allowRestrictedHeaders;
168       private static final Set<String> restrictedHeaderSet;
169       private static final String[] restrictedHeaders = {
170           /* Restricted by XMLHttpRequest2 */
171           //"Accept-Charset",
172           //"Accept-Encoding",
173           "Access-Control-Request-Headers",
174           "Access-Control-Request-Method",
175           "Connection", /* close is allowed */
176           "Content-Length",
177           //"Cookie",
178           //"Cookie2",
179           "Content-Transfer-Encoding",
180           //"Date",
181           //"Expect",
182           "Host",
183           "Keep-Alive",
184           "Origin",
185           // "Referer",
186           // "TE",
187           "Trailer",
188           "Transfer-Encoding",
189           "Upgrade",
190           //"User-Agent",
191           "Via"
192       };