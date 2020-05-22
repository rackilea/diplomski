public class HelloWorld {
    @Inject
    HelloService helloService;

    @GET
    @Path("/{helloSuffix}")
    public String getHello(@PathParam("helloSuffix") String helloSuffix) {
        return helloService.createHelloMessage(helloSuffix);
    }
}