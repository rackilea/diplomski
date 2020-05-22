@Provider
public class CustomExceptionMapper implements ExceptionMapper<Exception>
{
    @Override
    public Response toResponse(Exception exception) 
    {
        String error = exception.getMessage();
        return Response.status(Status.BAD_REQUEST).entity(error).type("text/plain").build();  
    }
}