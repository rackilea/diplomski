import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class XMLMarshalExceptionMapper implements ExceptionMapper<XMLMarshalException> {

    public Response toResponse(XMLMarshalException exception) {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}