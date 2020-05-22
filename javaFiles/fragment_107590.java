Set<Integer> mySet = new HashSet<Integer>();
 mySet.add(1);
 mySet.add(2);
 mySet.add(3);
 for (Set<Integer> s : SetUtils.powerSet(mySet)) {
     System.out.println(s);
 }