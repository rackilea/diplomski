List<String> arrayList1 = new ArrayList<String>(){{ add("One"); add("Two");   }}; 
List<String> arrayList2 = new ArrayList<String>(){{ add("Two"); add("Three"); }}; 
Set<String> tmpSet = new HashSet<String>(arrayList1);
tmpSet.addAll(arrayList2);
List<String> mergedList = new ArrayList<String>(tmpSet);
System.out.println(mergedList);