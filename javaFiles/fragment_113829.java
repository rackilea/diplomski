@Provider
public class CustomJsonProvider extends ResteasyJackson2Provider {

    @Override
    public void writeTo(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {

        ObjectMapper mapper = locateMapper(type, mediaType);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        super.writeTo(value, type, genericType, annotations, mediaType, httpHeaders, entityStream);
    }

}