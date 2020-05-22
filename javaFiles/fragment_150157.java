Arrays.sort(nums);

public boolean array220(int[] nums,  int index) {
  if (index >= nums.length-1) return false;

  if (binarySearch(index + 1, nums.length - 1,nums[index]*10,nums)) 
      return true; 

  return array220(nums, ++index);
}

public boolean binarySearch(int start, int end,int value, int[] nums){
     if(start > end)
        return false;
     int mid = (start + end)/2;
     if(nums[mid] == value){
         return true;
     }else if(nums[mid] > value){
         return binarySearch(start, mid - 1, value, nums);
     }else{
         return binarySearch(mid + 1, end, value, nums);
     } 
}