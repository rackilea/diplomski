String topicStatus = "1234:0,567:1,89:2";
String someId = "1234";
String regex = "\\b"+someId+":[0-2]\\b";

Pattern MY_PATTERN = Pattern.compile(regex);

Matcher m = MY_PATTERN.matcher(topicStatus);
while (m.find()) {
    String s = m.group(1);
    System.out.println(s);
}