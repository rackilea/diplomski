public boolean array220(int[] nums,HashSet<Integer> set,  int index) {
  if (index >= nums.length-1) return false;

  if (set.contains(nums[index]*10)) 
      return true; 
  set.add(nums[index]);
  return array220(nums,set, ++index);
}