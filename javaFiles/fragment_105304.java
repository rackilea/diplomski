private HttpMethod doREST(String request, RequestEntity entity) throws Exception {
    String uri = request;
    HttpMethod method;
    if ( entity != null ){
        PostMethod postMethod = new PostMethod(uri);
        postMethod.setRequestEntity(entity);
        method = postMethod;
    } else {
        method = new GetMethod(uri);
    }
    configureHttpMethod(method);
    HttpClient client = getHttpClient();
    client.getParams().setParameter(HttpClientParams.SO_TIMEOUT, timeoutLength);
    client.executeMethod(method);
    return method;
}