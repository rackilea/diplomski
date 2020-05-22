@Path("/")
public class MappingResource {

    private final RecordManager recman;

    public MappingResource(@Context RecordManager recman) { //<-- sweet! resource injection
        this.recman = recman;
    }


    @PUT
    @Path("/mapping/{key}")
    @Produces({MediaType.APPLICATION_JSON, "application/*+json"})
    public Response createMapping(@PathParam("key") String key, @QueryParam("val") String val) {
        // do something with recman, key and val
    }
}