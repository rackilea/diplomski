List<Integer> list1 = new ArrayList<>();
list1.add(1);
list1.add(2);
list1.add(3);

List<Integer> list2 = new ArrayList<>();
list2.add(11);
list2.add(22);
list2.add(33);

List<List<Integer>> list3 = new ArrayList<>();

for (int i = 0; i <list1.size(); i++) {

    List<Integer> tempList = new ArrayList<>();
    tempList.add(list1.get(i));
    tempList.add(list2.get(i));
    list3.add(tempList);
}
System.out.println(list3);