// initialize an ArrayList of n integers, from 0 to N-1
ArrayList<Integer> base = new ArrayList<>();
for (int i=0; i<n; i++) base.add(i);

// initialize each answer to a permutation of the base answer
Random r = new Random(); // use a seed if you want repeatable runs
for (Individual p : population) {
  int[] perm = new int[base.size()];
  Collections.shuffle(base, r);
  base.toArray(perm);
  p.setAnswer(perm);
}