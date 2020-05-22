public class HiHandler extends AzureSpringBootRequestHandler<User, Greeting> {

    @FunctionName("hi")
    public Greeting execute(@HttpTrigger(name = "request", methods = { HttpMethod.GET,
            HttpMethod.POST }, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<User>> request,
            ExecutionContext context) {

        context.getLogger().info("Greeting user name: " + request.getBody().get().getName());
        return handleRequest(request.getBody().get(), context);
    }
}