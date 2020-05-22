final String wholeString =
  "Typical models for star formation assume that every type of galaxy produces stars";
final int windowSize = 4;
final Map<String, String> generateMap = new LinkedHashMap<String, String>();

final int limit = wholeString.length() - windowSize;
for (int i = 0; i < limit;) generateMap.put(
      wholeString.substring(i, i + windowSize),
      wholeString.substring(++i, i + windowSize));

for (Map.Entry<String, String> e : generateMap.entrySet())
  System.out.println(e.getKey() + " -> " + e.getValue());