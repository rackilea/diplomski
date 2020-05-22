@GET
@Path("{count : [$]count(/)?}")
@Produces("text/plain")
public String getClichedMessageCount(
        @PathParam("count") String count) {

    return "Hello count";
}