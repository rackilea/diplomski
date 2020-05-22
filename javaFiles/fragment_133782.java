public enum Error {
  ERROR_1("-1", "foo went wrong"),
  ERROR_2("-2", "bar went wrong");

  private final String id;
  private final String message;

  Error(String id, String message) {
    this.id=id;
    this.message=message;
  }

  public String getId() {
    return id;
  }

  public String getMessage() {
    return message;
  }
}