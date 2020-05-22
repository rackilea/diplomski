@Named
public class TestFilter implements ContainerRequestFilter {
    private boolean globalError = true;

    public void filter(final ContainerRequestContext requestContext) throws IOException {
        if (globalError) {
            MediaType mediaType = requestContext.getAcceptableMediaTypes().size() > 0 ? requestContext.getAcceptableMediaTypes().get(0) : null;
            throw new WebApplicationException(Response.status(422).type(mediaType).entity(new TestEntity()).build());
        }
    } 
}