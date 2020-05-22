public class NotAuthorizedException extends WebApplicationException {
     public NotAuthorizedException(String message) {
         super(Response.status(Response.Status.UNAUTHORIZED)
             .entity(message).type(MediaType.TEXT_PLAIN).build());
     }
}