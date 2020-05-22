@Path("/customer")
@Resource
public class NeighborComparison {

    @GET @Path("/{customerId}") @Produces("text/plain")
    public String getNeighborComparison(@PathParam("customerId") long customerId) {
        return "foo";
    }
}