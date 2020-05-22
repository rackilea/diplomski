static final class DataUnwrapperAdapterFactory implements JsonAdapter.Factory {
  @Override
  public JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations, Moshi moshi) {
    if (!List.class.isAssignableFrom(Types.getRawType(type))) {
      return null;
    }
    if (!Data.class.isAssignableFrom(Types.getRawType(Types.collectionElementType(type, List.class)))) {
      return null;
    }
    JsonAdapter<List<Data>> listDelegate = moshi.nextAdapter(this, type, annotations);
    JsonAdapter<Data.Wrapper> wrapperDelegate = moshi.adapter(Data.Wrapper.class, annotations);
    return new DataUnwrapperAdapter(listDelegate, wrapperDelegate);
  }

  static final class DataUnwrapperAdapter extends JsonAdapter<List<Data>> {
    private final JsonAdapter<List<Data>> listDelegate;
    private final JsonAdapter<Data.Wrapper> wrapperDelegate;

    DataUnwrapperAdapter(JsonAdapter<List<Data>> listDelegate,
        JsonAdapter<Data.Wrapper> wrapperDelegate) {
      this.listDelegate = listDelegate;
      this.wrapperDelegate = wrapperDelegate;
    }

    @Override public List<Data> fromJson(JsonReader jsonReader) throws IOException {
      if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
        Data.Wrapper wrapper = wrapperDelegate.fromJson(jsonReader);
        return wrapper.data;
      } else {
        return listDelegate.fromJson(jsonReader);
      }
    }

    @Override public void toJson(JsonWriter jsonWriter, List<Data> list) throws IOException {
      listDelegate.toJson(jsonWriter, list);
    }
  }
}