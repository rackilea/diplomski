TreeSet<Integer> ts = new TreeSet<Integer>();
ts.add(1);
ts.add(4);
ts.add(4);
ts.add(3);

for (Integer i : ts) {
  System.out.println("current: " + i + " next:  " + ts.higher(i));
}