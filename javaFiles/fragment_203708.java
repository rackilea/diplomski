public class CustomHttpInvokerRequestExecutor extends SimpleHttpInvokerRequestExecutor {

private Map<String, String> headers;

public void setHeaders(Map<String, String> headers) {
    this.headers = headers;
}

@Override
protected void prepareConnection(HttpURLConnection connection, int contentLength) throws IOException {
    super.prepareConnection(connection, contentLength);

    if (headers != null) {
        // adding our custom headers
        for (String headerName : headers.keySet()) {
            connection.setRequestProperty(headerName, headers.get(headerName));
        }
        // do not want to persist headers for another request!
        headers.clear();
    }
}
}