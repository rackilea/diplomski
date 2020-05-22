@Override
public void serialize(Product value, JsonGenerator jgen, SerializerProvider provider) 
  throws IOException, JsonProcessingException {
    boolean revert = false;
    if (value.thumbnailUrl == null) {
      value.thumbnailUrl = "http://my.default.url";
      revert = true;
    }
    jgen.writeObject(value);
    if (revert) {
      value.thumbnailUrl = null;
    }
}