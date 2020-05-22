JsonDeserializer<?> jd = new JsonDeserializer<Example>() {
  @Override
  public Example deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    String enumStr = json.getAsString();
    String enumVal = enumStr.split("\\."); // etc...
    Example val = ... ...
    //...

    return val;
  }
};

Gson gson = new GsonBuilder().registerTypeAdapter(Example.class, jd).create();