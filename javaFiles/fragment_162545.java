import java.util.regex.Matcher;
import java.util.regex.Pattern;
...
String text = " Hi Guys \"Good Morning\"";
Pattern pattern = Pattern.compile("\"(.+?)\"");
Matcher matcher = pattern.matcher(text);
matcher.find();
System.out.println(matcher.group(1));