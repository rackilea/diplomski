public class MyReferenceObjectCodeDeserializer extends JsonDeserializer<MyReferenceObjectBean> {

@Override
public ColumnReferenceBean deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    MyReferenceObjectBean b = null;
    while (jp.nextToken() != JsonToken.END_OBJECT) {
        String fieldname = jp.getCurrentName();
        jp.nextToken();
        if ("code".equalsIgnoreCase(fieldname)) {
          b = MyReferenceObjectServiceImpl.retrieveByCode(jp.getText());
          logger.info("returning " +b.toString());
        }
    }
    if (b==null) logger.info("returning null");
    return b;
}
}