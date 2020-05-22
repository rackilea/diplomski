@Provider
@PreMatching
public class PreMatchingFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        if (requestContext.getHeaders().get("X-Use-Async") != null) {
            requestContext.setRequestUri(yourNewURI);
        }
    }
}