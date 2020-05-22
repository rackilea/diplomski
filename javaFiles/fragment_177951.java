private static boolean canAddToKFast2(int[] nums, int k) {
    Set<Integer> comps = new HashSet<>();
    for (int n : nums) {
        if (comps.contains(n))
            return true;
        comps.add(k - n);
    }
    return false;
}