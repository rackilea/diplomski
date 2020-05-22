try (InputStream s = response.getBody()) {
    LOG.info("response status code: {}, response headers: {}, response body:",
            response.getStatusCode(),
            response.getHeaders());
    String loggingResponseBody = new String(ByteStreams.toByteArray(s),
            StandardCharsets.UTF_8);
    LOG.info(loggingResponseBody); // One param means no format with {}
}