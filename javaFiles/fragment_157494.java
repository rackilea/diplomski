@Provider
public class AuditRequestFilter implements ContainerResponseFilter {

    @Context
    private HttpServletRequest request;

    @Context
    private ResourceInfo info;

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {

        int status = responseContext.getStatus();
        String remoteAddr = request.getRemoteAddr();

        UriInfo uriInfo = requestContext.getUriInfo();

        Class<?> resourceClass = info.getResourceClass();
        Method resourceMethod = info.getResourceMethod();
    }
}