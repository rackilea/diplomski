import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExCustomReplacementExample
{
  public static void main(String[] args)
  {
    System.out.println(
      new ReplaceFunction() {
        public String handle(String group)
        {
          return "«"+group.substring(1, group.length()-1)+"»";
        }
      }.replace("A simple *test* string", "\\*.*?\\*"));
  }
}
abstract class ReplaceFunction
{
  public String replace(String source, String regex)
  {
    final Pattern pattern = Pattern.compile(regex);
    final Matcher m = pattern.matcher(source);
    boolean result = m.find();
    if(result) {
        StringBuilder sb = new StringBuilder(source.length());
        int p=0;
        do {
          sb.append(source, p, m.start());
          sb.append(handle(m.group()));
          p=m.end();
        } while (m.find());
        sb.append(source, p, source.length());
        return sb.toString();
    }
    return source;
  }
  public abstract String handle(String group);
}