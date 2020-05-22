String inText="Sony Ericsson is a leading company in mobile. " +
              "The company sony ericsson was found in oct 2001";
String word = "sony ericsson";

Pattern p = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(inText);

StringBuffer sb = new StringBuffer();

while (m.find()) {
  String replacement = m.group().replace(' ', '~');
  m.appendReplacement(sb, Matcher.quoteReplacement(replacement));
}
m.appendTail(sb);

String outText = sb.toString();

System.out.println(outText);