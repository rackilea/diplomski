HttpUriRequest req = ...;
long length = -1L;
if (req instanceof HttpEntityEnclosingRequestBase) {
    HttpEntityEnclosingRequestBase entityReq = (HttpEntityEnclosingRequestBase) req;
    HttpEntity entity = entityReq.getEntity();
    if (entity != null) {
        // If the length is known (i.e. this is not a streaming/chunked entity)
        // this method will return a non-negative value.
        length = entity.getContentLength();
    }
}

if (length > -1L) {
    // This is the Content-Length. Some cases (streaming/chunked) doesn't
    // know the length until the request has been sent however.
}