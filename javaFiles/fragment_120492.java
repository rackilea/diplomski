String regex = "<ET>There were 4 calc errors:(.*?)</ET>";
Pattern p = Pattern.compile(regex, Pattern.DOTALL);
Matcher m = p.matcher(buf.toString());
while (m.find()) {
    String errorText = m.group(1);
    // Use errorText here
}