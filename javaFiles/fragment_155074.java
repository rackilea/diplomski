public class OverrideInputTypeResourceFilter implements ResourceFilter, ContainerRequestFilter {
    private MediaType targetType;
    private Set<MediaType> exemptTypes;

    OverrideInputTypeResourceFilter(
        @Nonnull String targetType,
        @Nonnull String[] exemptTypes
    ) {
        this.targetType = MediaType.valueOf(targetType);
        this.exemptTypes = new HashSet<MediaType>(Lists.transform(
            Arrays.asList(exemptTypes),
            exemptType -> MediaType.valueOf(exemptType)
        ));
    }

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        MediaType inputType = request.getMediaType();
        if (targetType.equals(inputType) || exemptTypes.contains(inputType)) {
            // unmodified
            return request;
        }

        MultivaluedMap<String, String> headers = request.getRequestHeaders();
        if (headers.containsKey(HttpHeaders.CONTENT_TYPE)) {
            headers.putSingle(HttpHeaders.CONTENT_TYPE, targetType.toString());
            request.setHeaders((InBoundHeaders)headers);
        }
        return request;
    }

    @Override
    public final ContainerRequestFilter getRequestFilter() {
        return this;
    }

    @Override
    public final ContainerResponseFilter getResponseFilter() {
        // don't filter responses
        return null;
    }
}