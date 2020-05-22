// from 'org.jsoup.helper.HttpConnection' class
static HttpConnection.Response execute(Connection.Request req, HttpConnection.Response previousResponse) throws IOException {
    // ...
    HttpURLConnection conn = createConnection(req);
    HttpConnection.Response res;
    try {
        // ...
    } finally {
        // per Java's documentation, this is not necessary, and precludes keepalives. However in practise,
        // connection errors will not be released quickly enough and can cause a too many open files error.
        conn.disconnect();
    }
    // ...
}