protected boolean canResponseHaveBody(final HttpRequest request,
    final HttpResponse response) {

    if ("HEAD".equalsIgnoreCase(request.getRequestLine().getMethod())) {
        return false;
    }
    final int status = response.getStatusLine().getStatusCode();
    return status >= HttpStatus.SC_OK
        // && status != HttpStatus.SC_NO_CONTENT
        && status != HttpStatus.SC_NOT_MODIFIED
        && status != HttpStatus.SC_RESET_CONTENT;
}