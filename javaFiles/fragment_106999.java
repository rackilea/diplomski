@Path("newconfiguration")
@RequestScoped
public class NewConfigurationResource {

@Context
private UriInfo context;

@Inject
private AreeConfiguration injConfig;

public NewConfigurationResource() { }

@POST
@Path("post")
@Produces("application/json")
public Response postJson() {
    ...
    doSomething(injConfig);
    ...
}