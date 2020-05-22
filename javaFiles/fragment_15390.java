@Provider
public class EntityNotFoundMapper implements ExceptionMapper<Exception> {

   public Response toResponse(Exception e) {
      // Do some logic like log an error
      return Response.status(Response.Status.NOT_FOUND).build();
   }
}