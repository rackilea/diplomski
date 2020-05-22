List<String[]> list = new ArrayList<String[]>();

String[] ar1 = {"1","JOHN","1934"};
String[] ar2 = {"2","TERENCE","1914"};

list.add(ar1);
list.add(ar2);

list.sort((c1,c2)->Integer.valueOf(c1[2]).compareTo(Integer.valueOf(c2[2])));

list.forEach(i->System.out.println(Arrays.toString(i)));