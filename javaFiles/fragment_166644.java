ArrayList<String> a = new ArrayList<>();
a.add("Hello World!");

ArrayList<String> b = a;

System.out.println(b); // prints [Hello World!]
a.clear();
System.out.println(b); // prints []