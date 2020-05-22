public boolean groupSum6(int start, int[] nums, int target) {
  if(start >= nums.length) return target == 0;

  int next = start + 1;
  int cur = nums[start];

  boolean minusCur = groupSum6(next, nums, target - cur);
  return (cur == 6) ? minusCur : (minusCur || groupSum6(next, nums, target));
}