final Matcher matcher =
    Pattern.compile("WITH\\s*", Pattern.DOTALL).matcher(test);
final StringBuffer sb = new StringBuffer();
while(matcher.find()){
    matcher.appendReplacement(sb, sb.length() == 0
        ? matcher.group()
        : "");
}
matcher.appendTail(sb);
System.out.println(sb.toString());