@Path("/{userId}")
public class MyResourceBean {
    ...
    @GET
    public String printUsername(@PathParam("userId") int userId) {
        ...
    }
}