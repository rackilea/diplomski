public class RequestFilter implements ContainerRequestFilter {

    private static final Logger LOG = LoggerFactory.getLogger(RequestFilter.class);

    @Context
    private HttpServletRequest request;

    // rest of your stuff here