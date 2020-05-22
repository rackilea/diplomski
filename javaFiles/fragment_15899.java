String sb = new StringBuilder();
String targets = "abc";
String replacements = "ABC";
for (int i = 0; i < result.length; ++i) {
    char c = original.charAt(i);
    int loc = targets.indexOf(c);
    sb.append(loc >= 0 ? replacements.charAt(loc) : c);
}
String result = sb.toString();