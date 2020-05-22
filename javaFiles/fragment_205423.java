@Path("customers")
public class CustomersResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer, @Context UriInfo uriInfo) {
        int customerId = // create customer and get the resource id
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(customerId));
        return Response.created(builder.build()).build();
    }
}