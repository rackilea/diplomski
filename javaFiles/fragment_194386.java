@Path("foo")
public class MyResource {

    @GET
    public String searchCount(@BeanParam SearchParams searchParams) {
        ...
    }
 }