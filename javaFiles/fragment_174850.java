List<Item> list = new ArrayList<Item>();
list.add(new Item());
list.add(new Item());

List<Item> list2 = new ArrayList<Item>();
list2.add(new Item());
list2.add(new Item());

Map<String,List<Item>> map = new HashMap<String,List<Item>>();
map.put("abc", list);
map.put("xyz", list);

ObjectMapper objectMapper = new ObjectMapper();
String writeValueAsString = objectMapper.writeValueAsString(map);