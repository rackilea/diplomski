Map<String, List<MyClass>> map = new HashMap<>();
List<MyClass> list = new ArrayList<>();
list.add(new MyClass(id_1));
map.put("key_1", list);
list.clear();
list.add(new MyClass(id_2));
map.put("key_2", new ArrayList<>(list));