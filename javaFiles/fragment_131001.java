JsonSerializer<Date> ser = new JsonSerializer<Date>() {
  @Override
  public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext 
             context) {
    return src == null ? null : new JsonPrimitive(src.getTime());
  }
};

JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
  @Override
  public Date deserialize(JsonElement json, Type typeOfT,
       JsonDeserializationContext context) throws JsonParseException {
    return json == null ? null : new Date(json.getAsLong());
  }
};

Gson gson = new GsonBuilder()
   .registerTypeAdapter(Date.class, ser)
   .registerTypeAdapter(Date.class, deser).create();