@Provider
@PreMatching
public class DisabledEndpointsFilter implements ContainerRequestFilter {

    @Inject
    private ConfigurationService configuration;


    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        final List<String> disabledEndpoints = this.configuration.getDisabledEndpoints();
        final String path = stripLeadingSlash(request.getUriInfo().getPath());

        for (String endpoint: disabledEndpoints) {
            endpoint = stripLeadingSlash(endpoint);
            if (path.startsWith(endpoint)) {
                request.abortWith(Response.status(404).build());
                return;
            }
        }
    }
}