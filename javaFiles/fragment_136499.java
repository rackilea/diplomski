public class Thrower {
  public Thrower() throws Exception {
    try {
      super();
      throw new Exception("By courtesy of thrower! ;)");
    } catch (Exception e) {
      ...
    }
  }
}