import java.util.regex.Matcher;
import java.util.regex.Pattern;

...

public ArrayList<String> GetMatchesFromNLP(String text) {
  ArrayList<String> matches = new ArrayList<String>();
  Matcher m = Pattern.compile("(?<=\\([A-Z]{2,3} )[^\\(\\)]+").matcher(text);
  while (m.find()) {
    matches.add(m.group());
  }
}