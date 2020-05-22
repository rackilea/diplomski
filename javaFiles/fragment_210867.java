Map<String, Object1> map1 = Maps.uniqueIndex(list1, Object1::getName);
Map<String, Object2> map2 = Maps.uniqueIndex(list2, Object1::getName);
for (String name : Sets.difference(map1.keySet(), map2.keySet()))
    processObject1(map1.get(name));
for (String name : Sets.difference(map2.keySet(), map1.keySet()))
    processObject2(map2.get(name));