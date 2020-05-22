List<List<String>> list1 = Arrays.asList(
    Arrays.asList("a"," b"),
    Arrays.asList("c", "d"),
    Arrays.asList("e", "f"),
    Arrays.asList("e", "f")
);
List<List<String>> list2 = Arrays.asList(
    Arrays.asList("1"," 2"),
    Arrays.asList("3", "4"),
    Arrays.asList("5", "6")
);
List<List<String>> result = new ArrayList<>();
for (int i  = 0; i < list1.size() || i < list2.size(); i++) {
    List<String> list = new ArrayList<>();
    if (i < list1.size()) {
        list.addAll(list1.get(i));
    }
    if (i < list2.size()) {
        list.addAll(list2.get(i));
    }
    result.add(list);
}
System.out.println(result);