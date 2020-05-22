@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException>{

    @Context
    private HttpHeaders headers;

    public Response toResponse(NotFoundException ex){
        return Response.status(404).entity(yourMessage).type( getAcceptType()).build();
    }

    private String getAcceptType(){
         List<MediaType> accepts = headers.getAcceptableMediaTypes();
         if (accepts!=null && accepts.size() > 0) {
             //choose one
         }else {
             //return a default one like Application/json
         }
    }
}