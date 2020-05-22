String[] items = string.split(",");
Map<String, String> map = new HashMap<String, String>();
for (String item : items) {
    String[] split = item.split(":");
    map.put(split[0], split[1]);
}