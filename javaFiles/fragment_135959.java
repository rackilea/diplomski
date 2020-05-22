public interface UserService {

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") Long userId);

}


@Path("/user")
class UserServiceImpl implements UserService {

    @Override
    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") Long userId) {
        // TODO Auto-generated method stub
        return null;
    }

}