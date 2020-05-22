public class CaseInsensitiveEnumTypeAdapterFactory implements TypeAdapterFactory {
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    Class<T> rawType = (Class<T>) type.getRawType();
    if (!rawType.isEnum()) {
      return null;
    }

    final Map<String, T> lowercaseToConstant = new HashMap<String, T>();
    for (T constant : rawType.getEnumConstants()) {
      lowercaseToConstant.put(toLowercase(constant), constant);
    }

    return new TypeAdapter<T>() {
      public void write(JsonWriter out, T value) throws IOException {
        if (value == null) {
          out.nullValue();
        } else {
          out.value(toLowercase(value));
        }
      }

      public T read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
          reader.nextNull();
          return null;
        } else {
          return lowercaseToConstant.get(toLowercase(reader.nextString()));
        }
      }
    };
  }

  private String toLowercase(Object o) {
    return o.toString().toLowerCase(Locale.US);
  }
}