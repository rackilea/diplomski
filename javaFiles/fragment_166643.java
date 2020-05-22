ArrayList<String> inner = new ArrayList<>();
ArrayList<ArrayList<String>> outer = new ArrayList<>();

inner.add("Hello World!");
outer.add(inner);
System.out.println(outer.get(0)); // prints [Hello World!]
inner.clear();
System.out.println(outer.get(0)); // prints [] i.e. an empty list