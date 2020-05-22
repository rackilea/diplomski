...
// Non integers as a separators
Pattern pattern = Pattern.compile("\\D+");
// List of extracted integers in previous line
List<Integer> previous = pattern.splitAsStream(prev)
    .filter(s -> !s.isEmpty())
    .map(Integer::valueOf)
    .collect(Collectors.toList());
// List of extracted integers in last line
List<Integer> current = pattern.splitAsStream(last)
    .filter(s -> !s.isEmpty())
    .map(Integer::valueOf)
    .collect(Collectors.toList());
// Do something here