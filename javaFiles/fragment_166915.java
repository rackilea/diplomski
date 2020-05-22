String regex = "\\d*";

Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(input);

StringBuffer sb = new StringBuffer();
StringBuffer replaced = new StringBuffer();
while(matcher.find()) {
    replaced.append(matcher.group());
    matcher.appendReplacement(sb, "");
}
matcher.appendTail(sb);

System.out.println(sb.toString());  // prints the replacement result
System.out.println(replaced.toString()); // prints what was replaced