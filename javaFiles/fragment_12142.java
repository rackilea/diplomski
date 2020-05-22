@Path("/customers")
public class CustomerResource {
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createCustomer(Customer customer, @Context UriInfo uriInfo) {
        int customerId = // create customer and get the resource id
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(customerId));
        return Response.created(builder.build()).build();
    }
}