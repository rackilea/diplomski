final HttpServletRequest req = (HttpServletRequest) request;
HttpServletRequest servletRequest = new ContentCachingRequestWrapper(req);
servletRequest.getParameterMap(); // needed for caching!!

String read = ByteSource.wrap(servletRequest.getContentAsByteArray())
    .asCharSource(StandardCharsets.UTF_8).read(); // Please note that we're not touching input stream!!