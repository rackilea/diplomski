/*
 * Restrict setting of request headers through the public api
 * consistent with JavaScript XMLHttpRequest2 with a few
 * exceptions. Disallowed headers are silently ignored for
 * backwards compatibility reasons rather than throwing a
 * SecurityException. For example, some applets set the
 * Host header since old JREs did not implement HTTP 1.1.
 * Additionally, any header starting with Sec- is
 * disallowed.
 *
 * The following headers are allowed for historical reasons:
 *
 * Accept-Charset, Accept-Encoding, Cookie, Cookie2, Date,
 * Referer, TE, User-Agent, headers beginning with Proxy-.
 *
 * The following headers are allowed in a limited form:
 *
 * Connection: close
 *
 * See http://www.w3.org/TR/XMLHttpRequest2.
 */
 private static final boolean allowRestrictedHeaders;
 private static final Set<String> restrictedHeaderSet;
 private static final String[] restrictedHeaders = {
    /* Restricted by XMLHttpRequest2 */
    //"Accept-Charset",
    //"Accept-Encoding",
    "Access-Control-Request-Headers",
    "Access-Control-Request-Method",
    "Connection", /* close is allowed */
    "Content-Length",
    //"Cookie",
    //"Cookie2",
    "Content-Transfer-Encoding",
    //"Date",
    //"Expect",
    "Host",
    "Keep-Alive",
    "Origin",
    // "Referer",
    // "TE",
    "Trailer",
    "Transfer-Encoding",
    "Upgrade",
    //"User-Agent",
    "Via"
};