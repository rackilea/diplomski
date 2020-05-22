final StringBuilder b = new StringBuilder();
final String matchWords = "Word12 Word13";
for (int i = 0; i < 300; i++) b.append("Word").append(i).append(" ");
final Matcher m =
  Pattern.compile(
    "((?:\\S+\\s+){0,50})" + Pattern.quote(matchWords) + "((?:\\s+\\S+){0,50})"
  ).matcher(b.toString());
if (m.find()) System.out.println("Words before: " + m.group(1) +
    "\nAfter: " + m.group(2));