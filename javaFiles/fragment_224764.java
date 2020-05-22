@POST
@Path("/fooPath")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public Response isSellableOnline(Store store) {
   store.getName();
...
}