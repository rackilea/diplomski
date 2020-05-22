@Provider
@PreMatching
@Priority(Priorities.HEADER_DECORATOR)
public class UserInterceptor implements ContainerRequestFilter {

    private static final Logger logger = Logger.getLogger(UserInterceptor.class.getName());


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        logger.info("requestContext.getHeaders() "+requestContext.getHeaders());
    }
}