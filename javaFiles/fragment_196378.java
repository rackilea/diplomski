import scalaz.*;

public class Javaz {
  public static void main(String[] args) {
    Validation<Throwable, String> res = new Success<Throwable, String>("test");

    if (res.isSuccess()) {
      System.out.println(((Success) res).a());
    } else {
      System.out.println(((Failure) res).e());
    }
  }
}