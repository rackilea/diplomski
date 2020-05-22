List<List<String>> result = new LinkedList<>();
List<String> current = null;
for (String s : lines) {
  if (s.startsWith("*")) {
    current = new LinkedList<>();
    result.add(current);
  } else {
    current.add(s);
  }
}