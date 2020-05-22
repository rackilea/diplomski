@Path("uri")
public class UriResource {

    @Inject
    Service service;

    @GET
    public String get() {
        return service.getUri();
    }
}