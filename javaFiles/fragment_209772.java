import java.text.Normalizer;
import java.util.regex.Pattern;

public class UrlifyString {
  public static String deAccent(String str) {
    String norm = Normalizer.normalize(str, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    return pattern.matcher(norm).replaceAll("").replace(" ", "-").toLowerCase();
  }

  public static void main(String[] args) {
    System.out.println(deAccent("Majstrovstvá v ľadovom hokeji"));
  }
}