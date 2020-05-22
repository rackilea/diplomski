@POST
@Path("/")
@Consumes("application/x-www-url-formencoded")
@Produces("application/json")
public String processImmediately(@FormParam("JSON") String json) {
    System.out.printf("Incoming JSON, decoded: %s\n", json);
    // ....
}