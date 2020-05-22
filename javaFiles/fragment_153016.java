@Path("..")
public class Resource { 
    @Inject
    ServiceXYZ pipeline;

    @GET
    public Response get() {
        pipeline.doSomething();
    }
}