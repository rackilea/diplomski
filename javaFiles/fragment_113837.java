@Path("customers")
public class CustomerResource {
    @PUT
    public Response createCustomer(Customer customer) {
        BeanValidator.validate(customer);
        final String rialtoId = customerProvider.createCustomer(customer);

        return Response.ok(rialtoId).build();
    }
}