String s  = "public class hello extends jframe";
Pattern p = Pattern.compile("public\\s*class\\s+(\\S+)");
Matcher m = p.matcher(s);
if (m.find()) {
    System.out.println("found");
    String className = m.group(1);
    System.out.println(className);
}