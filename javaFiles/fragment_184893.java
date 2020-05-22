public class MyResource {
    @POST
    @Path("/api/myservice")
    public SomeObject1 handleRequest1() {
        (...)
    }

    @POST
    @Path("/api/myservice2")
    public SomeObject2 handleRequest2() {
        (...)
    }
}