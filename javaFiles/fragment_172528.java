String content = "ZZZ AA PP [AA] Q[QQ] AAA ZZ";
String string = "(\\[.*?\\])";
Pattern pattern = Pattern.compile(string);
Matcher matcher = pattern.matcher(content);

int count = 0;
while (matcher.find())
    count++;

System.out.println("Found " + count + " matches.");