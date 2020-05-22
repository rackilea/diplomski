Pattern p = Pattern.compile("http\\://.+?\\.jpg");
Matcher m = p.matcher(content);
while (m.find())
{
     System.out.println(content.substring(m.start(), m.end()));
}