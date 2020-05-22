A a = new A(1);
List<I> list = new LinkedList<>();
list.add(a);
System.out.println(list.get(0).getValue()); // 1
a.setValue(2);
System.out.println(list.get(0).getValue()); // 2