String src = "text_abc";

// Can move these to class level for reuse.
final HashMap<String, String> map = new HashMap<>();
map.put("a", "d");
map.put("b", "e");
map.put("c", "f");
final Pattern pattern = Pattern.compile("[abc]");

String replaced = src;
Matcher matcher;
while ((matcher = pattern.matcher(replaced)).find())
    replaced = matcher.replaceFirst(map.get(matcher.group()));

// System.out.println(replaced);