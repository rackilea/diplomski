String property = "file:${user.home}/some-directory";

StringBuffer sb = new StringBuffer();
Pattern pattern = Pattern.compile("\\$\\{(.+)\\}");
Matcher matcher = pattern.matcher(property);
while (matcher.find())
{
    String key = matcher.group(1);
    String val = System.getProperty(key);
    if (val != null)
    {
        matcher.appendReplacement(sb, Matcher.quoteReplacement(val));
    }
}
matcher.appendTail(sb);
System.out.println(sb.toString());