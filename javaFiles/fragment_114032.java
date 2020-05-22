public static Result login() {

    // set to "/login" -- The URI path without query parameters.
    String path = request().path(); 

    // set to "/login?param=test" -- The full URI.
    String uri = request().uri(); 

    // set to "example.com:9000" -- The host name from the request, with port (if specified by the client).
    String host = request().host(); 

    ...
}