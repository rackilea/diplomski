final Set<Number> ns = new HashSet<>();
final short s = 1;
ns.add(s);
ns.add(s+0);
ns.add(s+0L);
System.out.println(ns); // prints [1, 1, 1]