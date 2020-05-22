String input = "~~40~~ Celsius Temp: 33 Celsius Temp:~~50~~";
Pattern p = Pattern.compile("~~");
Matcher m = p.matcher(input);
StringBuffer sb = new StringBuffer(input.length());
int i = 0;

while (m.find()) {
    if (i % 2 == 0) {
        m.appendReplacement(sb, "**");
    }
    else {
        m.appendReplacement(sb, m.group(0));
    }
    ++i;
}
m.appendTail(sb);
System.out.println(sb.toString());

**40~~ Celsius Temp: 33 Celsius Temp:**50~~