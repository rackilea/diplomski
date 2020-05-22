static final Object VOID_JSON_ADAPTER = new Object() {
  @FromJson Void fromJson(JsonReader reader) throws IOException {
    return reader.nextNull();
  }

  @ToJson void toJson(JsonWriter writer, Void v) throws IOException {
    writer.nullValue();
  }
};