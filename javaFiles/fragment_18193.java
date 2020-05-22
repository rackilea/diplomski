InputStream is = socket.getInputStream();
HttpTransportMetricsImpl metrics = new HttpTransportMetricsImpl();
SessionInputBufferImpl buf = new SessionInputBufferImpl(metrics, 2048);
buf.bind(is);

DefaultHttpRequestParser reqParser = new DefaultHttpRequestParser(buf);
HttpRequest req = reqParser.parse();
InputStream contentStream = null;
if (req instanceof HttpEntityEnclosingRequest) {
    ContentLengthStrategy contentLengthStrategy = StrictContentLengthStrategy.INSTANCE;
    long len = contentLengthStrategy.determineLength(req);
    if (len == ContentLengthStrategy.CHUNKED) {
        contentStream = new ChunkedInputStream(buf);
    } else if (len == ContentLengthStrategy.IDENTITY) {
        contentStream = new IdentityInputStream(buf);
    } else {
        contentStream = new ContentLengthInputStream(buf, len);
    }
}
// Do something useful with the content stream (if non null)