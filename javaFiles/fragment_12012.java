public class DateNotSpecifiedFilter implements ContainerRequestFilter {

    @Context ExtendedUriInfo extendedUriInfo;

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        boolean methodNeedsDateHeader = extendedUriInfo.getMatchedMethod().isAnnotationPresent(DateRequired.class);
        String dateHeader = request.getHeaderValue(HttpHeaders.DATE);

        if (methodNeedsDateHeader && dateHeader == null) {
            Exception cause = new IllegalArgumentException("Date Header was not specified");
            throw new WebApplicationException(cause, Response.Status.BAD_REQUEST);
        } else {
            return request;
        }
    }
}