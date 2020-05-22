if (useSync) {
    requestContext.getHeaders().putSingle(
        HttpHeaders.CONTENT_TYPE, "application/vnd.example.sync+text");
} else {
    requestContext.getHeaders().putSingle(
        HttpHeaders.CONTENT_TYPE, "application/vnd.example.async+text");
}