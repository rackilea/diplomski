Map<String, String> items = new TreeMap<String, String>(new Comparator<String>() {
  public int compare(String a, String b) {
    return b.compareTo(a);
  }
});

items.put("A", "1");
items.put("B", "2");
items.put("C", "3");

for (String s: items.keySet()) {
  System.out.println(s + " " + items.get(s));
}