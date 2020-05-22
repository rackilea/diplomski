Pattern pattern = Pattern.compile("_([a-z0-9])");
Matcher matcher = pattern.matcher("foo_bar_baz_2");

StringBuffer stringBuffer = new StringBuffer();
while(matcher.find()) {
    matcher.appendReplacement(stringBuffer, matcher.group(1).toUpperCase());
}
matcher.appendTail(stringBuffer);

System.out.println(stringBuffer.toString());