GsonBuilder gsonBuilder = new GsonBuilder();        
gsonBuilder.registerTypeAdapter(Float.class,  new JsonSerializer<Float>() {
  @Override
  public JsonElement serialize(final Float src, final Type typeOfSrc, final JsonSerializationContext context) {
      BigDecimal value = BigDecimal.valueOf(src);    
      return new JsonPrimitive(value);
  }
});

Gson gson = gsonBuilder.create();
String json = gson.toJson(data);