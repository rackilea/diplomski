public static void permutation(List<coordinate> nums) {
    List<List<coordinate>> accum = new ArrayList<List<coordinate>>();
    permutation(accum, Arrays.<coordinate>asList(), nums);
    System.out.println(accum);
}

private static void permutation(List<List<coordinate>> accum, List<coordinate> prefix, List<coordinate> nums) {
    int n = nums.size();
    if (n == 0) {
        accum.add(prefix);
    } else {
        for (int i = 0; i < n; ++i) {
            List<coordinate> newPrefix = new ArrayList<coordinate>();
            newPrefix.addAll(prefix);
            newPrefix.add(nums.get(i));
            List<coordinate> numsLeft = new ArrayList<coordinate>();
            numsLeft.addAll(nums);
            numsLeft.remove(i);
            permutation(accum, newPrefix, numsLeft);
        }
    }
}