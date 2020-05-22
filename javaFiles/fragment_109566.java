Map<String, Class> types = ...// map of supported types
JsonToken token = jsonParser.nextToken();
if(token == JsonToken.FIELD_NAME){ // "object1" etc.
    String name = jsonParser.getCurrentName();
    Class type = types.get(name);
    Object object = jsonParser.readValueAs(type);
}