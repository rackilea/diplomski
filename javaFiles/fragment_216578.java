public class CustomJacksonConverter extends JacksonConverter {
 private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

 @Override
 public <T> float score(Representation source, Class<T> target, Resource resource) {
     // Restlet will use this function to determine which converter to be use. We yeild 1.0F equals to say: I will handle it from here
     if (source.getMediaType().getName().contains("json")) {
        return 1.0F;
     }
     return super.score(source, target, resource);
 }

 @Override
 public <T> T toObject(Representation source, Class<T> target, Resource resource) throws IOException {
    // Write stream to object
    return OBJECT_MAPPER.readValue(source.getStream(), target);
 }