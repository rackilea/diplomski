List<Integer> list = new LinkedList<Integer>();
list.add(1);
list.add(2);
list.add(3);
list.add(4);
list.add(5);
list.add(6);
list.add(7);
list.add(8);
list.add(9);
list.add(10);

removeElements(list);

for (int x = 0; x < list.size(); x++)
   System.out.println(list.get(x));

// output: 1 2 4 5 7 8 10