import org.joda.time.*;

public class Test {
  public static void main(String[] args) {
      DateTime dt = new DateTime(1111111111, DateTimeZone.UTC);
      System.out.println(dt); // Prints 1970-01-13T20:38:31.111Z
  }
}