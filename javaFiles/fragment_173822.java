@POST
@Path("/")
@Consumes("application/json")
@Produces("application/json")
public String processImmediately(String json) {
    System.out.printf("Incoming JSON, decoded: %s\n", json);
    // ....
}