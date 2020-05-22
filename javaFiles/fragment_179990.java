@Path("example")
public class ExampleResource {

    private String name;

    public ExampleResource(String name) {
        this.name = name;
    }

    @GET
    @RolesAllowed("ADMIN")
    public String get() {
        return "Hello " + name + "!";
    }

    @GET
    @Path("root")
    @RolesAllowed("ROOT")
    public String getRoot() {
        return "Root Access";
    }
}