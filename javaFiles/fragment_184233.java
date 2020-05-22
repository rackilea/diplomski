import java.util.regex.*;

public class RegexToCountWords {
  public static final String SAMPLE_STRING = "The fox and the hound";
  public static final String SEARCH_STRING = "the";

  public static void main(String[] args) {
    // pattern to compare \\b matches word boundaries
    Pattern pattern = Pattern.compile("\\b" + SEARCH_STRING + "\\b");
    Matcher matcher = pattern.matcher(SAMPLE_STRING.toLowerCase());
    //matcher.find() checks for all occurrances
    int count = 0;
    while (matcher.find()) {
      count++;
    }
    System.out.println("Sample String : " + SAMPLE_STRING);
    System.out.println("Number of matching strings : " + count);
  }