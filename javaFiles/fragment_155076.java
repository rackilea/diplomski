@Produces(MediaType.APPLICATION_JSON)
@Path(/objects/{id}")
public class MyResource {
    @PUT
//  @Consumes(MediaType.APPLICATION_JSON)
    @OverrideInputType(MediaType.APPLICATION_JSON)
    public StatusResult put(@PathParam("id") int id, JsonObject obj) {
        log.trace("PUT {}", id);
        // do something with obj
        return new StatusResult(true);
    }

    @GET
    public JsonObject get(@PathParam("id") int id) {
        return new JsonObject(id);
    }
}