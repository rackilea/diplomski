import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartMediaTypes;

@Path("/")
public class TestResource {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MultiPartMediaTypes.MULTIPART_MIXED})
    public Response getData(@Context UriInfo ui) {
        final boolean condition = false;
        if (condition) {
            return Response.ok("{}", MediaType.APPLICATION_JSON).build();
        }

        return Response.ok(
            new MultiPart()
                .bodyPart("This is the first segment", MediaType.TEXT_PLAIN_TYPE)
                .bodyPart("<outer><inner>value</inner></outer>", MediaType.TEXT_XML_TYPE),
            MultiPartMediaTypes.MULTIPART_MIXED_TYPE
        ).build();
    }
}