ArrayList<String> al = new ArrayList<String>();
String arr[] = {"Zero", "One", "Two"}; 
//Convert string array to a collection 
Collection l = Arrays.asList(arr);
al.addAll(l); 
i.putStringArrayListExtra("ar", al);