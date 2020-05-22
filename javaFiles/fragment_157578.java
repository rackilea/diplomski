String input = "This is <abc_d> a sample <ea1_j> input <lmk_02> string";
Matcher matcher = Pattern.compile("<([^>]*)>").matcher(input);
StringBuffer sb = new StringBuffer();
while(matcher.find()) {
    matcher.appendReplacement(sb, manipulateValue(matcher.group(1)));
}
matcher.appendTail(sb);
System.out.println(sb.toString());