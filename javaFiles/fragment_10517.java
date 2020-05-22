public static String firstContainsChars(Stream<String> items, String charset) {
  char[] inChars = charset.toCharArray();
  for (char ch : inChars) {
    items = items.filter(s -> s.contains(String.valueOf(ch)));
  }
  return items.findFirst().orElse("No Match Found");
}