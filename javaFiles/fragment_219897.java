@Produces("application/xml")
@Path("xml")
@javax.enterprise.context.RequestScoped // CDI one, not JSF one
public class MyResource {

    @Context
    private SecurityContext securityContext;

    @Inject
    private MyDAO myDAO; // MyDAO = EJB Bean

    @GET
    @Path("some/path")
    public Foo getFoo() {
        return myDAO.getFooByUserName(securityContext.getUserPrincipal().getName());
    }
}