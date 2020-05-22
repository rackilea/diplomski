public interface RestClient{

    @GET
    @Path("/")
    public String getUserSecureCode( @QueryParam("username") String username ,@QueryParam("password") String password)
}