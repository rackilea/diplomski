Set<Integer> set = new HashSet<Integer>(l2);
for (Integer i : l1) {
    if (set.contains(i)) {
        System.out.println("Found!");
    }
}