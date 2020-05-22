Map<String, Set<String>> map1; // [key="B";values=["Beryllium", "Boron", "Bromine"]]
Map<String, Set<String>> map2; // [key="B";values=["Bismuth"] key="I";values=["Iron"]]

for (Entry<String, Set<String>> entry : map2.entrySet()) {
   map1.merge(entry.getKey(), entry.getValue(), (s1, s2) -> {s1.addAll(s2); return s1;});
}

//map1 = [key="B";values=["Beryllium", "Boron", "Bromine", "Bismuth"] key="I";values=["Iron"]]