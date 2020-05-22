@GET
@Path("/{test}")
@Produces("application/json")
public String getJson(@PathParam("test") String test) {
    return test;
}