Object o = new Collection[0]; // SC is Collection
System.out.println(o instanceof Object[]); // TC is class type Object -> true
System.out.println(o instanceof String[]); // TC is class type other than Object -> false
System.out.println(o instanceof Collection[]); // TC == SC -> true
System.out.println(o instanceof Iterable[]); // TC is super interface of SC -> true
System.out.println(o instanceof List[]); // TC is not super interface SC -> false