final class TextPlainToApplicationJsonContentTypeRewriteFilter implements ContainerRequestFilter {

    @Override
    ContainerRequest filter(ContainerRequest request) {
        if(request.getHeaderValue(HttpHeaders.CONTENT_TYPE).trim().startsWith(MediaType.TEXT_PLAIN)) {
            request.requestHeaders.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        }

        request
    }
}