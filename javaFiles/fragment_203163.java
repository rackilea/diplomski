public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6};
    int k = 3;

    List<List<Integer>> subsets = new ArrayList<List<Integer>>(a.length / k);
    for (int i = 0; i < a.length / k; i++)
        subsets.add(new ArrayList<Integer>(k));
    solve(a, k, 0, subsets);
}