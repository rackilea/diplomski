List<Map<A, B>> list = new ArrayList<>();

// Compiler error! Pretend it's OK, though.
List<Map<? extends A, ? extends B>> list2 = list;

Map<SubclassOfA, SubclassOfB> map = new HashMap<>();
list2.add(map);

list.get(0).put(new A(), new B());