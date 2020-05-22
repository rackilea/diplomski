String text = "plan plans lander planitia";
String pattern = "\\w*(lan)\\w+";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(text);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    m.appendReplacement(sb, m.group(0).replaceFirst(Pattern.quote(m.group(1)), "<--->"));
}
m.appendTail(sb); // append the rest of the contents
System.out.println(sb.toString());
// output => plan p<--->s <--->der p<--->itia