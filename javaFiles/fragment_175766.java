@GET
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Path("{id}")
public Customer read(@PathParam("id") long id) {
    return entityManager.find(Customer.class, id);
}