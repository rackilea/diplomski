@GET
@Path("{id}")
@Produces({"application/xml"})
public Employee find(@PathParam("id") String id) {

    return (Employee) map.get(id);

}