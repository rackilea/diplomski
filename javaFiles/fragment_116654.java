protected Response doInvoke(String httpMethod, Object body, Class<?> responseClass, Type genericType) {

    MultivaluedMap<String, String> headers = getHeaders();
    if (body != null) {
        if (headers.getFirst(HttpHeaders.CONTENT_TYPE) == null) {
            headers.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_TYPE.toString());
        }
    } else {
        headers.putSingle(HttpHeaders.CONTENT_TYPE, MediaType.WILDCARD);
    }
    if (responseClass != null && headers.getFirst(HttpHeaders.ACCEPT) == null) {
        headers.putSingle(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML_TYPE.toString());
    }
    resetResponse();
    return doChainedInvocation(httpMethod, headers, body, responseClass, genericType, null, null);
}