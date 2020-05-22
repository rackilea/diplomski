@POST
@Consumes(MediaType.APPLICATION_JSON)
@Path("/joinRide/{rideid}")
public Response joinRide(@PathParam("rideid") long rideid) {
    System.out.println(rideid);
}