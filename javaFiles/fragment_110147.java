public class MyRequestClassDeserializer extends JsonDeserializer<MyRequestClass> {
    @Override
    public MyRequestClass deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        MyRequestClass mrc = new MyRequestClass();
        ObjectMapper mapper = new ObjectMapper();
        JsonToken currentToken = null;
        while((currentToken = jsonParser.nextValue()) != null) {
            if(currentToken.equals(JsonToken.END_OBJECT) 
                    || currentToken.equals(JsonToken.END_ARRAY))
                continue;
            String currentName = jsonParser.getCurrentName();
            switch(currentName) {
                case "attribute1":
                    List<SomeClass> attr1 = Arrays.asList(mapper.readValue(jsonParser, SomeClass[].class));
                    mrc.setAttribute1(attr1);
                    break;
                case "attribute2":
                    mrc.setAttribute2(mapper.readValue(jsonParser, SomeOtherClass.class));
                    break;
                case "attribute3":
                    mrc.setAttribute3(mapper.readValue(jsonParser, YetAnotherClass.class));
                    break;
                // <cases for all the other expected attributes>
                default:// it's not an expected attribute
                    throw new JsonParseException(jsonParser, "bad request", jsonParser.getCurrentLocation());
            }
        }
        return mrc;
    }
}