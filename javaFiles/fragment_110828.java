static boolean repeatRequest(ClientRequestContext request, ClientResponseContext response, String newAuthorizationHeader) {
    Client client = request.getClient();

    String method = request.getMethod();
    MediaType mediaType = request.getMediaType();
    URI lUri = request.getUri();

    WebTarget resourceTarget = client.target(lUri);

    Invocation.Builder builder = resourceTarget.request(mediaType);

    MultivaluedMap<String, Object> newHeaders = new MultivaluedHashMap<String, Object>();

    for (Map.Entry<String, List<Object>> entry : request.getHeaders().entrySet()) {
        if (HttpHeaders.AUTHORIZATION.equals(entry.getKey())) {
            continue;
        }
        newHeaders.put(entry.getKey(), entry.getValue());
    }

    newHeaders.add(HttpHeaders.AUTHORIZATION, newAuthorizationHeader);
    builder.headers(newHeaders);

    builder.property(REQUEST_PROPERTY_FILTER_REUSED, "true");

    Invocation invocation;
    if (request.getEntity() == null) {
        invocation = builder.build(method);
    } else {
        invocation = builder.build(method,
                Entity.entity(request.getEntity(), request.getMediaType()));
    }
    Response nextResponse = invocation.invoke();

    if (nextResponse.hasEntity()) {
        response.setEntityStream(nextResponse.readEntity(InputStream.class));
    }
    MultivaluedMap<String, String> headers = response.getHeaders();
    headers.clear();
    headers.putAll(nextResponse.getStringHeaders());
    response.setStatus(nextResponse.getStatus());

    return response.getStatus() != Response.Status.UNAUTHORIZED.getStatusCode();
}