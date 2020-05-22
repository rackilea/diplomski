@Path("/message")
public class MessageServices {

    @PUT
    @Path("/sendsms")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response sendSms() {
        //....
    }

}