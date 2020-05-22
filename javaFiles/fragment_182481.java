@Controller
@Path("/greeting/")
@RequestScoped
public class GreetingResource {

    // javax.ws.rs.core.Context
    @Context
    ServletContext servletContext;

    // OR

    @GET
    @Path("/test")
    @Produces({ MediaType.TEXT_PLAIN })
    public Response test(@Context ServletContext servletContext) {
        // return ...
    }
}