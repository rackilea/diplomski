DefaultHttpClient httpclient = new DefaultHttpClient();

HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {

public boolean retryRequest(
        IOException exception, 
        int executionCount,
        HttpContext context) {
    if (executionCount >= 5) {
        // Do not retry if over max retry count
        return false;
    }
    if (exception instanceof InterruptedIOException) {
        // Timeout
        return false;
    }
    if (exception instanceof UnknownHostException) {
        // Unknown host
        return false;
    }

    if (exception instanceof SocketTimeoutException) {
        //return true to retry 
        return true;
    }

    if (exception instanceof ConnectException) {
        // Connection refused
        return false;
    }
    if (exception instanceof SSLException) {
        // SSL handshake exception
        return false;
    }
    HttpRequest request = (HttpRequest) context.getAttribute(
            ExecutionContext.HTTP_REQUEST);
    boolean idempotent = !(request instanceof HttpEntityEnclosingRequest); 
    if (idempotent) {
        // Retry if the request is considered idempotent 
        return true;
    }
    return false;
}

};

httpclient.setHttpRequestRetryHandler(myRetryHandler);