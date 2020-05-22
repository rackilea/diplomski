@FunctionName("HttpTrigger-Java")
public HttpResponseMessage run(
        @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, route="{customRoute}", authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<Optional<String>> request,
        @BindingName("customRoute")String route,
        final ExecutionContext context) {
    context.getLogger().info("Java HTTP trigger processed a request.");

    if(route.equals("home")){
        return request.createResponseBuilder(HttpStatus.OK).body("Home route request").build();
    }
    else if(route.equals("id")){
        return request.createResponseBuilder(HttpStatus.OK).body("Id route request").build();
    }
    else{
        return request.createResponseBuilder(HttpStatus.NOT_FOUND).body("Not a valid route").build();
    }
}