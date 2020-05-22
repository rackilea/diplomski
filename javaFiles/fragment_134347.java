@Path("/login")
public class LoginService  {    

    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @POST
    public Response login(LoginRequest loginRequest) throws Exception {  
    // your code
    }