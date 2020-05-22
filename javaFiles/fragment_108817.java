@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getDrivers() {
    System.out.println("printline from drivers api");
    GenericEntity<List<Driver>> entity = new GenericEntity<List<Driver>>( dao.getDrivers() ){};
    return Response.ok(entity).build();
}