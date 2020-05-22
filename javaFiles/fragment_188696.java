public class SecureResource {

    @GET
    @SecurityChecked
    public Response getUser() {
        return Response.ok("authenticated successfully!").build();
    }
}