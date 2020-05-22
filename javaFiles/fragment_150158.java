public boolean array220(int[] nums,  int index) {
  if (index >= nums.length-1) return false;

  if (linearSearch(0,nums[index]*10,nums)) 
      return true; 

  return array220(nums, ++index);
}

public boolean linearSearch(int start, int value, int[] nums){
     if(start >= nums.length)
        return false;

     if(nums[start] == value){
         return true;
     }else {
         return linearSearch(start + 1, value, nums);
     } 
}