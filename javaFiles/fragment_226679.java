public final class MapModelDeserializer extends BeanDeserializer {
   public MapModelDeserializer(BeanDeserializerBase src) {
    super(src);
   }

  protected void handleUnknownProperty(JsonParser jp, DeserializationContext ctxt, Object beanOrClass, String propName) throws IOException, JsonProcessingException {
    if ("content".equals(propName)) {
      MapModelResponseList response = (MapModelResponseList) beanOrClass;

      // this probably needs null checks!
      JsonNode details = (JsonNode) jp.getCodec().readTree(jp).get("data").get("details");

      // read as array and create a Data object for each element
      if (details.isArray()) {
        List<Data> data = new java.util.ArrayList<Data>(details.size());

        for (int i = 0; i < details.size(); i++) {
           Data d = jp.getCodec().treeToValue(details.get(i), Data.class);
           data.add(d);
        }

        response.setData(data);
      }
      // read a single object
      else {
         Data d = jp.getCodec().treeToValue(details, Data.class);
         response.setData(java.util.Collections.singletonList(d));
      }

    super.handleUnknownProperty(jp, ctxt, beanOrClass, propName);
}