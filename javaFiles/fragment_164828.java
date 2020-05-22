String input = "===foo=== ==bar== ==baz== ===bam===";

Map<String, String> replacements = new HashMap<>();
replacements.put("===", "<subheading>${value}</subheading>");
replacements.put("==", "<heading>${value}</heading>");

Pattern p = Pattern.compile("(?<eqAmount>={2,3})(?<value>[^=]*)\\k<eqAmount>");

StringBuffer sb = new StringBuffer();
Matcher m = p.matcher(input);
while (m.find()) {
    m.appendReplacement(sb, replacements.get(m.group("eqAmount")));
}
m.appendTail(sb);

String result = sb.toString();
System.out.println(result);