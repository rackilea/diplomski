public class EmailInfo implements Serializable {
    private String rideId;
    private String email;

    // Constructors, Getters/Setters
}

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Path("/joinRide")
public Response joinRide(EmailInfo info) {
    System.out.println(info.getRideId());
    System.out.println(info.getEmail());
}