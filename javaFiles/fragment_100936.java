int sum(int[] nums) {
  if (nums.length == 0) {
    return 0;
  } else {
    return nums[0] + sum(Arrays.copyOfRange(nums, 1, nums.length));
  }
}