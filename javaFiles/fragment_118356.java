@Provider
public class UserNotFoundMapper implements
        ExceptionMapper<UserNotFoundException> {
    @Override
    public Response toResponse(UserNotFoundException ex) {
        return Response.status(404).entity(ex.getMessage()).type("text/plain")
                .build();
    }
}