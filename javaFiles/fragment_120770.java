@ApplicationPath("checkClass")
public class MyApplication extends ResourceConfig {

    public MyApplication () {
        register(TestingClass.class);
        register(SecureImplementation.class);
    }
}


@Path("/checkFilter")
public class TestingClass{

    @Secured
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, String> testing(Input input)