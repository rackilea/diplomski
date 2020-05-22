public Mono<ServerResponse> toRESTInVerticle(ServerRequest serverRequest) {
    String uri = serverRequest.uri().toString();
    String method = serverRequest.methodName();
    String contentType = serverRequest.headers().contentType().get().toString();
    String characterSet = serverRequest.headers().acceptCharset().get(0).toString();
    JSONObject bodyData = serverRequest.bodyToMono(JSONObject.class).toProcessor().peek();

    System.out.println("==========toRESTInVerticle Data Check==========");
    System.out.println(uri);
    System.out.println(method);
    System.out.println(contentType);
    System.out.println(characterSet);
    System.out.println(bodyData);
    System.out.println("======toRESTInVerticle Data Check Complete======");

    return Mono.empty();
}