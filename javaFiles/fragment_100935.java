int sum(int[] nums) {
  return sum(0, nums);
}

int sum(int index, int[] nums) {
  if (index == nums.length) {
    return 0;
  } else {
    return nums[index] + sum(index + 1, nums);
  }
}