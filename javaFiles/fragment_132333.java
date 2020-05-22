@Path("weather")
public class MainResource {

    @Inject
    private MainDep dep;

    @GET
    public String printGotIt() {
        return "Got it!";
    }

    @GET
    @Path("propaganda")
    public String printPropaganda() {
        return dep.printPropaganda();
    }
}