public final class MYInterfaceAdapter implements JsonDeserializer<MyInterface>, JsonSerializer<MyInterface> {
  private static final String PROP_NAME = "myClass";

  @Override
  public MyInterface deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    try {
      String classPath = json.getAsJsonObject().getAsJsonPrimitive(PROP_NAME).getAsString();
      Class<MyInterface> cls = (Class<MyInterface>) Class.forName(classPath);

      return (MyInterface) context.deserialize(json, cls);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public JsonElement serialize(MyInterface src, Type typeOfSrc, JsonSerializationContext context) {
    // note : won't work, you must delegate this
    JsonObject jo = context.serialize(src).getAsJsonObject();

    String classPath = src.getClass().getName();
    jo.add(PROP_NAME, new JsonPrimitive(classPath));

    return jo;
  }
}