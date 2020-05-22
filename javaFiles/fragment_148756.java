List<Integer> l = new ArrayList<Integer>();
((List)l).add("hello");
System.out.println("Added successfully");

Iterator it = l.iterator();              // Old-fashioned raw iterator works
while (it.hasNext()) {
    System.out.println(it.next());
}

for (Object o : l) {                     // Enhanced for with Object works
    System.out.println(o);
}

for (Integer i : l) {                    // But this throws when it reaches the
    System.out.println(i);               // String, because String cannot be cast
}                                        // to Integer