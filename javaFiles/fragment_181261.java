List<List<String>> list1 = new ArrayList<List<String>>();
List<String> list2 = new ArrayList<String>();

list2.add("foo");
System.out.println(list2); //[foo]
list1.add(new ArrayList<String>(list2)); // take a copy of the list.
System.out.println(list1); //[[foo]]
list2.set(0, "bar");
System.out.println(list2); //[bar]
System.out.println(list1); //[[foo]]