TreeMap<Integer,String> tree = new TreeMap<Integer,String>();
tree.put (1, "Bobby");
tree.put(6, "Sue");
tree.put (3, "Mary");
tree.put (8, "John");
tree.put (15, "Joe");
System.out.println(tree.floorEntry(7)); // Sue
System.out.println(tree.floorEntry(9)); // John