@Provider
public class LoggingResponseFilter
    implements ContainerResponseFilter {

private static final Logger logger =      LoggerFactory.getLogger(LoggingResponseFilter.class);

public void filter(ContainerRequestContext requestContext,
        ContainerResponseContext responseContext) throws IOException {
    String method = requestContext.getMethod();

    logger.debug("Requesting " + method + " for path " + requestContext.getUriInfo().getPath());
    Object entity = responseContext.getEntity();
    if (entity != null) {
        logger.debug("Response " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(entity));
    }
}