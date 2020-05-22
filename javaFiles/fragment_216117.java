public static void main(String[] args) {
    List<List<Integer>> transactions = Arrays.asList(Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21), Arrays.asList(2, 3, 6, 10), Arrays.asList(11, 21));

    SortedSet<Integer> set = new TreeSet<>();
    for (List<Integer> l : transactions) {
        set.addAll(l);
    }
}