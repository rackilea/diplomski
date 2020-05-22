String s = "word 123 some text inside next 567";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("(\\w+)\\s+(\\d+)").matcher(s);
while (m.find()) {
    String wrd = m.group(1);
    String num = m.group(2);
    String replacement = wrd.toUpperCase() + num;
    m.appendReplacement(result, replacement);
}
m.appendTail(result);
System.out.println(result.toString());