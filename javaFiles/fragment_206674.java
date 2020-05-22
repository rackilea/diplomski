Map<String, List<String>> m = new HashMap<>();
if (m.containsKey("key")) {
   m.get("key").add("new value");
}
else {
  List<String> l = new ArrayList<>();
  l.add("new value");
  m.put("key", l);
}