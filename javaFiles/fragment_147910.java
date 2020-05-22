@Provider
@Consumes("application/zip")
public class ZipMessageBodyReader implements MessageBodyReader<InputStream> {
    @Override
    public boolean isReadable(Class<?> type, Type genericType, 
            Annotation[] annotations, MediaType mediaType) {
        return type == InputStream.class;
    }

    @Override
    public InputStream readFrom(Class<InputStream> type, 
            Type genericType, Annotation[] annotations, MediaType mediaType, 
            MultivaluedMap<String, String> httpHeaders, 
            InputStream entityStream) throws IOException, WebApplicationException {

        return entityStream;
    }  
}