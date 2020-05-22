import org.jboss.resteasy.spi.ResteasyProviderFactory;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.my.pkg.JsonMappingExceptionMapper;

@Path("/init")
public class InitResource {

    @GET
    public Response init() {
        ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();
        factory.getExceptionMappers().put(JsonMappingException.class, 
                                          new JsonMappingExceptionMapper());
        return Response.ok("Done!").build();
    }
}