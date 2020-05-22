@Provider
public class JsonMappingExceptionMapper 
             implements ExceptionMapper<JsonMappingException> {

    @Override
    public Response toResponse(JsonMappingException e) {
        return Response.status(Response.Status.BAD_REQUEST).build();
    } 
}