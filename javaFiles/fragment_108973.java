Map map = new HashMap();
map.put("one", "1st");
map.put("two", new Integer(2));
map.put("three", "3rd");
for (Object o : map.entrySet()) {
    Map.Entry entry = (Map.Entry) o;
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}