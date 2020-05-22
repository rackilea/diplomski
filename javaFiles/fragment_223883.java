@ApplicationException
public class RESTException extends WebApplicationException {
    private static final long serialVersionUID = 1L;
    public RESTException(Status status, String msg) {
        super(Response.status(status).entity(msg).type(MediaType.TEXT_PLAIN).build());
    }
}