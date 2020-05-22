public class BaseTypeAdapterFactory implements TypeAdapterFactory {

  public <T> TypeAdapter<T> create(Gson gson, final TypeToken<T> type) {
    if(BaseType.class.isAssignableFrom(type.getRawType())) {
      TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
      return newItemAdapter((TypeAdapter<BaseType>) delegate,
          gson.getAdapter(new TypeToken<MyDTO>(){}));
    } else {
      return null;
    }
  }

  private TypeAdapter newItemAdapter(
      final TypeAdapter<BaseType> delagateAdapter,
      final TypeAdapter<MyDTO> dtoAdapter) {
    return new TypeAdapter<BaseType>() {

      @Override
      public void write(JsonWriter out, BaseType value) throws IOException {
        delagateAdapter.write(out, value);
      }

      @Override
      public BaseType read(JsonReader in) throws IOException {
        MyDTO dto = dtoAdapter.read(in);
        if("base".equals(dto.type)) {
          return new BaseType(dto);
        } else if ("type_a".equals(dto.type)) {
          return new TypeA(dto);
        } else {
          return null;
        }
      }
    };
  }
}