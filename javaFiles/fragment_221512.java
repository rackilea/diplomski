JsonDeserializer<?> jd = new JsonDeserializer<ElementType>() {
  @Override
  public ElementType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    String enumStr = json.getAsString();
    ElementType val = 
    //...

    return val;
  }
};

Gson gson = new GsonBuilder().registerTypeAdapter(ElementType.class, jd).create();