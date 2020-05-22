import java.util.regex.Matcher;
import java.util.regex.Pattern;

class test {

  public static void main(String... args) {
    String  input   = "21-02-2015 wordA 22 wordB wordC Førtids";
    Matcher matcher = Pattern.compile("[\\w&&[^\\d]]+",
                                      Pattern.UNICODE_CHARACTER_CLASS)
                      .matcher(input);

    while (matcher.find() ) {
      System.out.println(matcher.group() );
    }
  }

}