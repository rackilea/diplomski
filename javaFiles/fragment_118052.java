import java.util.regex.*;
//.....
String s = "abc";
List<String> results = new ArrayList<>();
Matcher m = Pattern.compile("\\P{M}\\p{M}*+").matcher(s);
while (m.find()) {
    results.add(m.group());
}
System.out.println(results);  // => [, , a, b, c, ]