List<String> list1 = Arrays.asList("foo");
List<String> list2 = Arrays.asList("bar");
Set<List<String>> set = new HashSet<List<String>>();
set.add(list1);
set.add(list2);
list1.add("baz"); 
list2.add("qux");
set.addAll(set); // throws ConcurrentModificationException