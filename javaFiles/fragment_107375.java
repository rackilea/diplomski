ArrayList<Integer> list = new ArrayList<Integer>();
list.add(54);
list.add(12);
list.add(62);
list.add(54);
list.add(12);
list.add(43);
list.add(62);

list = new ArrayList<>(new TreeSet<>(list));
System.out.println(list);