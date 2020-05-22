@Path("/dealer")
public class Dealers {
    @GET
    public List<Dealer> getAll() { ... }
    @GET
    @Path("search/byZip")
    public List<URI> getByZip(@QueryParam("zip") String zip, ...) { ... }
    @Path("{dealerId:[^/]+}")
    public Dealer getDealer(@PathParam("dealerId") String id) { ... }
}