List<String> list = new ArrayList<>();
list.add("null");
list.add(null);
System.out.println(list); // prints [null, null]
assert list.size() == 2;
list.remove(null);
assert list.size() == 1;

list.remove(null); // can't remove the "null" this way.
assert list.size() == 1;

System.out.println(list); // prints [null]
list.remove("null");
assert list.size() == 0;