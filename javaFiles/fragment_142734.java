public class InstantParamProvider implements ParamConverterProvider {

    @Inject
    private javax.inject.Provider<UriInfo> uriInfoProvider;

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, 
                                              Type genericType, 
                                              Annotation[] annotations) {

        if (rawType != Instant.class) return null; 

        return new ParamConverter<T>() {
            @Override
            public T fromString(String value) {
                UriInfo uriInfo = uriInfoProvider.get();
                String format = uriInfo.getQueryParameters().getFirst("date-format");

                if (format == null) {
                     throw new WebApplicationException(Response.status(400)
                             .entity("data-format query parameter required").build());
                } else {
                    try {
                        // parse and return here
                    } catch (Exception ex) {
                        throw new WebApplicationException(
                            Response.status(400).entity("Bad format " + format).build());
                    }
                }
            }

            @Override
            public String toString(T value) {
                return value.toString();
            }  
        };
    }  
}