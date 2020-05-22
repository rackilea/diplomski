@Provider()
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public class MyFileProvider implements MessageBodyWriter<File> {

    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return File.class.isAssignableFrom(type);
    }

    public void writeTo(File t, Class<?> type, Type genericType, Annotation annotations[], MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
        InputStream in = new FileInputStream(t);
        try {
            int read;
            final byte[] data = new byte[ReaderWriter.BUFFER_SIZE];
            while ((read = in.read(data)) != -1) {
                entityStream.write(data, 0, read);
                // fire some event as progress changes
            }
        } finally {
            in.close();
        }
    }

    @Override
    public long getSize(File t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return t.length();
    }
}