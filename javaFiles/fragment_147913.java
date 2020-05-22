@Provider
@Produces("application/xml")
public class ZipClientMessageBodyWriter implements MessageBodyWriter<File> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, 
            Annotation[] annotations, MediaType mediaType) {
        return type == File.class;
    }

    @Override
    public long getSize(File t, Class<?> type, Type genericType, 
            Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(File t, Class<?> type, Type genericType, 
            Annotation[] annotations, MediaType mediaType, 
            MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) 
            throws IOException, WebApplicationException {

        IOUtils.write(IOUtils.toByteArray(new FileInputStream(t)), entityStream);
    }  
}

....

client.register(ZipClientMessageBodyWriter.class);