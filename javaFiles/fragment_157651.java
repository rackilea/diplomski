@Override
public WebServiceConnection createConnection(URI uri) throws IOException {
    HttpPost httpPost = new HttpPost(uri);
    if (isAcceptGzipEncoding()) {
        httpPost.addHeader(HttpTransportConstants.HEADER_ACCEPT_ENCODING,
                HttpTransportConstants.CONTENT_ENCODING_GZIP);
    }
    HttpContext httpContext = createContext(uri);
    return new CustomHttpComponentsConnection(getHttpClient(), httpPost, httpContext);
}