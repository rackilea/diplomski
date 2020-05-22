@Provider
@Consumes("application/zip")
public class ZipMessageBodyReader implements MessageBodyReader<ZipInputStream> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, 
            Annotation[] annotations, MediaType mediaType) {
        return type == ZipInputStream.class;
    }

    @Override
    public ZipInputStream readFrom(Class<ZipInputStream> type, 
            Type genericType, Annotation[] annotations, MediaType mediaType, 
            MultivaluedMap<String, String> httpHeaders, 
            InputStream entityStream) throws IOException, WebApplicationException {

        return new ZipInputStream(entityStream);
    }    
}