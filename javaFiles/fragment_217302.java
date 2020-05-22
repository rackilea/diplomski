ArrayList arrayList = new ArrayList();
arrayList.add(0);
arrayList.add(1);
arrayList.add(2);
arrayList.add(3);
arrayList.add(4);
arrayList.add(5);
arrayList.add(6);
arrayList.add(7);
System.out.println("Before shuffling, ArrayList contains : " + arrayList);
Object obj = arrayList.remove(7); // remove by index!
Object obj1 = arrayList.remove(2);
Collections.shuffle(arrayList);
arrayList.add(2, obj1);
arrayList.add(7, obj);
System.out.println("After shuffling, ArrayList contains : " + arrayList);