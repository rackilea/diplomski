String value1 = "\"http://:2123\"123";
String pattern1 = "\"(http|ftp|socket)://(?<!\\bXmlNamespace\\(.{0,1000}\"(http|ftp|socket)://)(?!www\\.google-analytics\\.com(/collect)?)(:\\d*)?[\"/]\\w";
Pattern ptrn = Pattern.compile(pattern1);
Matcher matcher = ptrn.matcher(value1);
if (matcher.find())
    System.out.println("true");
else
    System.out.println("false");