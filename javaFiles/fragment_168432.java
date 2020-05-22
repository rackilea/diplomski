public class Value {

  private final String keyword;

  private Value(String keyword) {
    this.keyword = keyword;
  }
  public String getKeyword() {
    return keyword;
  }
  @Override
  public String toString() {
    return keyword;
  }
}