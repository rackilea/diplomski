List<String> a = new ArrayList<String>();
List<String> b = new ArrayList<String>();

a.add("a");
a.add("b");
a.add("c");

b.add("a");
b.add("c");

System.out.println("b is a subset of a: " + a.containsAll(b));

System.out.println("a is a subset of b: " + b.containsAll(a));