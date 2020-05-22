List<Integer> list1 = new ArrayList<Integer>();
List<Integer> list2 = list1;
list1 = new ArrayList<Integer>();
list1.add(1);

System.out.println(list1.size()); //1
System.out.println(list2.size()); //0