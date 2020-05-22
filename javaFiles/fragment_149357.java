private String handleResponse(HttpResponse response) {
    final int statusCode = response.getStatusCode();

    if (statusCode == HttpStatus.SC_OK) {
        return response.getEntity().toString();
    }

    throw getExceptionByStatusCode(statusCode);
}

private MyDomainHTTPException getExceptionByStatusCode(int statusCode) {
    switch (statusCode) {
        case HttpStatus.SC_NOT_FOUND:
            return new MyDomainHTTPException("...");
        case HttpStatus.SC_UNAUTHORIZED:
            return new MyDomainHTTPException("...");
        default:
            return new MyDomainHTTPException("...");
    }
}