@POST
@Consumes(MediaType.APPLICATION_JSON)
@Path("/joinRide")
public Response joinRide(String json) {
    System.out.println(json);
}