BufferedReader reader = new BufferedReader(...???...);
NameMetrics current = null;
List<NameMetrics> result = new ArrayList<>();
while (true) {
  String s = reader.readLine();
  if (s == null) {
    break;  // end reached
  }
  if (s.trim().isEmpty()) {
    continue;  // Skip empty line
  }
  int cut = s.indexOf(':');
  if (cut == -1) {
    cut = s.indexOf('-');
    if (cut == -1) {
      continue;
    }
    current = new NameMetrics();
    current.setName(s.substring(0, cut));
    result.add(current);
  } else if (current != null) {
    current.setMetrics(s.substring(0, cut), s.substring(cut+1));
  }
}