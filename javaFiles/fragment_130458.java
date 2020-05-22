Map<String, String> map = new HashMap<String, String>();
// add entries to the map here

for (Map.Entry<String, String> entry : map.entrySet()) {
    String k = entry.getKey();
    String v = entry.getValue();
    System.out.printf("%s %s\n", k, v);
}