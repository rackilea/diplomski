private static boolean setETagHeaders(String etag, String mime) {
    response().setHeader("Cache-Control", "no-cache");
    response().setHeader("ETag", "\"" + etag + "\"");
    boolean ifNoneMatch = false;

    if (request().hasHeader(IF_NONE_MATCH)) {
        String header = request().getHeader(IF_NONE_MATCH);
        //removing ""
        if (!etag.equals(header.substring(1, header.length() - 1))) {
            response().setHeader(CONTENT_TYPE, mime);
        } 
        ifNoneMatch = true;
    } else {
        response().setHeader(CONTENT_TYPE, mime);
    }
    return ifNoneMatch;
}