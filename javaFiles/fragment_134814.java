ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();

ArrayList<Integer> tempArrayList = new ArrayList<Integer>();

tempArrayList.add(1);
tempArrayList.add(2);
tempArrayList.add(3);
tempArrayList.add(4);
arrayList.add(tempArrayList);

System.out.println(arrayList.get(0).get(0));
System.out.println(arrayList.get(0).get(1));

tempArrayList = new ArrayList<Integer>();

tempArrayList.add(5);
tempArrayList.add(6);
tempArrayList.add(7);
tempArrayList.add(8);
arrayList.add(tempArrayList);

System.out.println(arrayList.get(1).get(0));
System.out.println(arrayList.get(1).get(1));

etc...