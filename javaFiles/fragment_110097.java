public class PoweredByResponseFilter implements ContainerResponseFilter {

    @Inject
    HttpServletRequest request;

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
        throws IOException {
            String name = "X-My-Header";
            String value = "";// some data from request
            responseContext.getHeaders().add(name, value);
    }
}