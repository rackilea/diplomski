import java.io.IOException;
import java.lang.annotation.Annotation;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Provider
public class IdValidationFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Context
    private HttpServletRequest request;

    @Override
    public void filter(final ContainerRequestContext requestContext) throws IOException {


        for (Annotation annotation : resourceInfo.getResourceMethod().getDeclaredAnnotations()) {

            if (IdValidation.class == annotation.annotationType()) {
                 this.requestContext = requestContext;
            MultivaluedMap<String, String> map = requestContext.getUriInfo().getPathParameters();
            if (map.containsKey("someId")) {
                    // Do some validation and abort if nessecary
            }
            }
        }
    }

}