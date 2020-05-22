import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
   public static void main(String[] args) {
      new Test().run();
   }

   private void run() {
      String mama = "mama";
      Pattern vcv =
            Pattern.compile("([aeiou])(?=[bcdfghjklmnpqrstvwxyz][aeiou])");
      Matcher matcher = vcv.matcher(mama);

      System.out.println(matcher.replaceAll("$1-"));
      String mamama = "mamama";
      matcher = vcv.matcher(mamama);
      System.out.println(matcher.replaceAll("$1-"));
   }

}