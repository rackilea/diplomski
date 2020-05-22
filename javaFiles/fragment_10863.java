String[] a ={"A","B"};
String[] b={"A","B","C"};
List<String> list=new ArrayList<String>();
list.addAll(Arrays.asList(a));
list.retainAll(Arrays.asList(b));
System.out.println(list);
System.out.println("equal elements:"+list.size());