@Provider
public class SecurityExceptionMapper implements ExceptionMapper<SecurityException>{
  @Override 
  public Response toResponse(SecurityException arg0) {
    return Response.status(403).build();
  }
}