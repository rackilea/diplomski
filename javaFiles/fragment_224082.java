@Provider
public class StatsFilter implements ContainerRequestFilter {
    @Override
    public ContainerRequest filter(ContainerRequest request) {
        final CachedEntityContainerRequest cachedRequest
                = new CachedEntityContainerRequest(request);

        final Saying saying = cachedRequest.getEntity(Saying.class);

        return cachedRequest;
    }
}