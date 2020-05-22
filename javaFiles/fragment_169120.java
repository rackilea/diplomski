public int[] calculateGap(int[] nums) {
    if (nums.length < 2) {
        throw new IllegalArgumentException();
    }

    int[] dist = new int[nums.length - 1];
    for (int i = 1; i < nums.length; i++) {
        dist[i - 1] = Math.abs(nums[i] - nums[i - 1]);
    }
    return dist;
}