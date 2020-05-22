ArrayList<ArrayList<Integer>> v = new ArrayList<ArrayList<Integer>>();
v.add(new ArrayList<Integer>());

v.get(0).add(new Integer(5));
v.get(0).add(new Integer(10));
System.out.println(v.get(0).get(0)); // => 5
System.out.println(v.get(0).get(1)); // => 10