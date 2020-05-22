Set<Integer> grid = new HashSet<Integer>();
Random rand = new Random();

while (grid.size() < 25) {
    Integer val = rand.nextInt(100);
    grid.add(val);
}