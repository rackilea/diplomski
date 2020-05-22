str = "This and that 'with you and me and others' and not 'her and him'";
Matcher matcher = Pattern.compile("('[^']*?')").matcher(str);
StringBuffer sb = new StringBuffer();
while (matcher.find()) {
   matcher.appendReplacement(sb, matcher.group(1).replaceAll("and", "XXX"));
}
matcher.appendTail(sb);
System.out.println("Output: " + sb);