StringBuilder sb = new StringBuilder(data.length());
Map<String, String> replacements = Map.of("\\u003C", "<", "\\u003E", ">" /* etc */);
for (int i = 1; i < data.length() - 1; ++i) {
  sb.append(data.charAt(i));

  for (Map.Entry<String, String> entry : replacements.entrySet()) {
    String search = entry.getKey();

    // This is basically checking "endsWith".
    int endIndex = sb.length() - search.length();
    if (endIndex >= 0 && sb.indexOf(search, endIndex) == endIndex) {
      sb.delete(endIndex, sb.length());
      sb.append(entry.getValue());
    }
   }
}
data = sb.toString();