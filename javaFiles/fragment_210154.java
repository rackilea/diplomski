List<String> list = new LinkedList<>();
list.add("hello");
list.add("world");
list.add("one");
list.add("two");
list.add("three");
System.out.println(Arrays.toString(list.toArray()));
ListIterator<String> iter = list.listIterator();
String s;
while ((s = iter.next()) != null && !s.equals("world"))
    ;
// When it is time to delete
iter.remove();
System.out.println(Arrays.toString(list.toArray()));