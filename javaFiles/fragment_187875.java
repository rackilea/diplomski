@Path("/operation") 
public class Operation {

    @Context
    protected UriInfo info;

    @GET 
    public String operation() {
        if (info.getQueryParameters().containsKey("create"))
            // do stuff
        else if (info.getQueryParameters().containsKey("info"))
            // other stuff
    }