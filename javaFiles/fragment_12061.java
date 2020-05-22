import java.util.Locale;

public class Test {
  public static void main(String[] args) {
    Locale.setDefault(new Locale("hi", "IN"));
    System.out.printf("String: %s; Number: %d\n", 1234, 1234);
  }
}