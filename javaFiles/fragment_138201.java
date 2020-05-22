import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    public static void main( String args[] ){

      // String to be scanned to find the pattern.
      String line = "I am a !!!guy!!! but I like !!!cats!!! better than dogs.";
      String pattern = "!!!(.*?)!!!";

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      while (m.find( )) {
         //--> If you want a array do the logic you want with m.group(1)
         System.out.println("Found value: " + m.group(1) );
      }
   }
}