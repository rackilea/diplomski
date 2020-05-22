public class MyEnumAdapterFactory implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type) {
            Class<? super T> rawType = type.getRawType();
            if (rawType == RequestStatus.class) {
                return new MyEnumTypeAdapter<T>();
            }
            return null;
    }

    public class MyEnumTypeAdapter<T> extends TypeAdapter<T> {

         public void write(JsonWriter out, T value) throws IOException {
              if (value == null) {
                   out.nullValue();
                   return;
              }
              RequestStatus status = (RequestStatus) value;
              // Here write what you want to the JsonWriter. 
              out.beginObject();
              out.name("value");
              out.value(status.name());
              out.name("code");
              out.value(status.getCode());
              out.endObject();
         }

         public T read(JsonReader in) throws IOException {
              // Properly deserialize the input (if you use deserialization)
              return null;
         }
    }

}