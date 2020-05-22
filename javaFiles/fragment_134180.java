public int firstMissingPositive(int[] nums) {
    int k;
    for (int i = 1;; i++) {
        final int j = i;
        if (! Arrays.stream(nums).anyMatch(x -> x != j)) {
            k = j;
            break;
        }
    }
    return k;
}