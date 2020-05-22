@GET
@Path("/example")
public Response getExample(@QueryParam("lastName") String lastName, 
                           @QueryParam("surname") String surname) {
    String name = (lastName != null) ? lastName : surname;
}