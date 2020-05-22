Set<Integer> set = new HashSet<Integer>();
Random rand = new Random();

while (set.size() < 10) {
    set.add(rand.nextInt((1000000)));
}