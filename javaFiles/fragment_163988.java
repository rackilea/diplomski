Random r = new Random(<a seed number>);

Set<Integer> mySet = new HashSet<Integer>();
while (mySet.size() < 5) {
   int idx = r.nextInt(<length of your data>)
   mySet.add(data[idx]);
}