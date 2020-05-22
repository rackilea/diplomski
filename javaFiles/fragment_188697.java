@Interceptor
@Provider
@ServerInterceptor
@SecurityChecked
public class SecurityCheckInterceptor implements PreProcessInterceptor, AcceptedByMethod {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityCheckInterceptor.class);

    @Nullable
    @Override
    public ServerResponse preProcess(final HttpRequest request, final ResourceMethod method) throws Failure, WebApplicationException {
        final List<String> authToken = request.getHttpHeaders().getRequestHeader("X-AUTH");

        if (authToken == null || !isValidToken(authToken.get(0))) {
            final ServerResponse serverResponse = new ServerResponse();
            serverResponse.setStatus(Response.Status.UNAUTHORIZED.getStatusCode());
            return serverResponse;
        }

        return null;
    }

    private static boolean isValidToken(@Nonnull final String authToken) {
        LOGGER.info("validating token: " + authToken);
        return true;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean accept(final Class declaring, final Method method) {
        // return declaring.isAnnotationPresent(SecurityChecked.class); // if annotation on class
        return method.isAnnotationPresent(SecurityChecked.class);
    }
}