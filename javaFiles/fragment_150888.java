List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 5, 6));
list1.retainAll(list2);
list2.removeAll(list1);
list1.addAll(list2);
System.out.println(list1);