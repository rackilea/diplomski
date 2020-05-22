List<String> a1 = new ArrayList<>();
a1.add("8");
a1.add("a1");
List<List<String>> a2 = new ArrayList<>();
a2.add(a1);
a2.addAll(a1); // <<== Does not compile
List<String> a3 = new ArrayList<>();
a3.add(a1);    // <<== Does not compile
a3.addAll(a1);