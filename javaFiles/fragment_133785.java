ArrayList arrayList = new ArrayList();

//Add elements to Arraylist
arrayList.add("1");
arrayList.add("3");
arrayList.add("5");
arrayList.add("2");
arrayList.add("4");


Collections.sort(arrayList);

//display elements of ArrayList
System.out.println("ArrayList elements after sorting in ascending order : ");
for(int i=0; i<arrayList.size(); i++)
    System.out.println(arrayList.get(i));