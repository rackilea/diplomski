public class ServiceHandler<T> {
  private final TypeToken<List<T>> typeToken;

  public ServiceHandler(TypeToken<List<T>> typeToken) {
    this.typeToken = typeToken;
  }

  // ...

  private List<T> createListResponseHandler(String string_response) {
    return gson.fromJson(string_response, typeToken.getType());
  }
}