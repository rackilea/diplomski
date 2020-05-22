import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Simple{
  public static void main(String args[]){
    String str = "22  24  +";
    // Variant 1 - split
    String [] outArr = str.split(" +(?=\\d{1,3}|[+-])");
    System.out.println(Arrays.toString(outArr));
    // Variant 2 - find all matches
    List<String> allMatches = new ArrayList<String>();
    Matcher m = Pattern.compile("\\d{1,3}|[-+]").matcher(str);
    while (m.find()) {
      allMatches.add(m.group());
    }
    System.out.println(Arrays.toString(allMatches.toArray()));
  }
}