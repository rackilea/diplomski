@Path("/my/path")
public class MyResource
{
    private RestContext rc;

    @Inject
    public MyResource(RestContext rc)
    {
        this.rc = rc;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void upload(MyPostObj data)
    {
        // do stuff here, and rc is all set up
    }
}