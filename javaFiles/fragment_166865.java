@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        packages("...");
    }
    @GET
    @Produces("text/plain")
    public Response foo() {

        return Response.ok("Hey, it's working!\n").build();
    }
}