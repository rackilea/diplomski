@GET
@Path("/emp")
public Response getEmployees(@QueryParam("filter") String filter) {
    // The filter needs to be converted to an Employee object. Use your
    // favorite JSON library to convert. I will illustrate the conversion
    // with Jackson, since it ships with Jersey
    final Employee empTemplate = new ObjectMapper().readValue(filter, Employee.class);

    // Do your database search, etc, etc
    final String id = getMatchingId(empTemplate);

    // return an appropriate response
    return Response.status(200).entity(id).build();
}