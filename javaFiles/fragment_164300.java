@Path("foo")
public class FoosResource {
    @GET  // get all `Foo` resources
    ...
    @GET 
    @Path("{id}")  // get `Foo` with this id
    ...
    @POST // create new `Foo` in `foo` collection
    ...
    @PUT 
    @Path("{id}")  // Update `Foo` with this id
}