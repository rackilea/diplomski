Map<String, Object> map = new TreeMap<String, Object>();
/* Add entries to the map in any order. */
...
/* Now, iterate over the map's contents, sorted by key. */
for (Map.Entry<String, ?> entry : map.entrySet()) {
  System.out.println(entry.getKey() + ": " + entry.getValue());
}