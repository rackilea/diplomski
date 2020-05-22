String text = "aaaaaaBccccCCCCd"; //a6B1c4C4d1
String regex = "(.)(\\1*)"; 
String pattern = "test";
Pattern r = Pattern.compile(regex);
Matcher m = r.matcher(text);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    m.appendReplacement(sb, m.group(1) + (m.group(2).length()+1));
}
m.appendTail(sb);
System.out.println(sb);