@Provider
@Singleton
public class ExceptionMapperProvider implements ExceptionMapper<Exception>
{

    @Override
    public Response toResponse(final Exception exception)
    {
            return Response.status(HttpStatusCodes.STATUS_CODE_SERVER_ERROR).entity(new BasicResponse(InternalStatus.UNHANDLED_EXCEPTION, exception.getMessage())).type(MediaType.APPLICATION_JSON).build();    
    }
}

@XmlRootElement
public class BasicResponse {

    public String internalStatus;

    public String message;

    public BasicResponse() {}

    public BasicResponse(String internalStatus, String message){
        this.internalStatus = internalStatus;
        this.message = message;
    }
}