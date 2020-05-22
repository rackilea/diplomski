249       // the following http request headers should NOT have their values
250       // returned for security reasons.
251       private static final String[] EXCLUDE_HEADERS = {
252               "Proxy-Authorization",
253               "Authorization"
254       };
255   
256       // also exclude system cookies when any might be set
257       private static final String[] EXCLUDE_HEADERS2= {
258               "Proxy-Authorization",
259               "Authorization",
260               "Cookie",
261               "Cookie2"
262       };