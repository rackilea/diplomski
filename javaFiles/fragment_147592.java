Map<Integer, String> numbers = new HashMap<>();
Map<Integer, String> numbers2 = new HashMap<>();
numbers.put(1, "one");
numbers.put(2, "two");
numbers2.put(3, "three");
numbers2.put(4, "four");
BiFunction<String, String, String> func = (v1, v2) -> v2;
BiConsumer<Integer, String> cons = (k, v) -> numbers.merge(k, v, func);
numbers2.forEach(cons);