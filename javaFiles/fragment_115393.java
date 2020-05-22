public static boolean groupSum1(int start, int[] nums, int target)
  {
  1.    if (start >= nums.length) return (target == 0);             
  2.    if (groupSum1(start + 1, nums, target - nums[start])) return true;              
  3.    if (groupSum1(start + 1, nums, target)) return true;            
  4.    return false;
  }