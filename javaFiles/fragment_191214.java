@Provider
    @Consumes("application/json")
    public class CustomJsonReader<T> implements MessageBodyReader<T> {
        @Override
        public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
            return true;
        }

    @Override
    public T readFrom(Class<T> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
            InputStream entityStream) throws IOException, WebApplicationException {

        /*
         * Copy the input stream to String. Do this however you like. Here I use
         * Commons IOUtils.
         */
        StringWriter writer = new StringWriter();
        IOUtils.copy(entityStream, writer, "UTF-8");
        String json = writer.toString();

        /*
         * if the input stream is expected to be deserialized into a String,
         * then just cast it
         */
        if (String.class == genericType)
            return type.cast(json);

        /*
         * Otherwise, deserialize the JSON into a POJO type. You can use
         * whatever JSON library you want, here's a simply example using GSON.
         */
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, type);
    }
    }