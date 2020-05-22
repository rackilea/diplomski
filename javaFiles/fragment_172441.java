public boolean split53(int[] nums) {
  return isPossible(nums,0,0,0); 
}
public boolean isPossible(int[] nums,int start,int sum3,int sum5) {
  if(start>=nums.length) return sum3==sum5;
  int tmp=nums[start];

  if(tmp%5==0 || tmp%3==0) {
    if(nums[start]%5==0) {
      if(isPossible(nums,start+1,sum3,sum5+tmp)) return true;
    }
    else if(nums[start]%3==0) {
      if(isPossible(nums,start+1,sum3+tmp,sum5)) return true;
    }  
  } else {
    if(isPossible(nums,start+1,sum3+tmp,sum5)) return true;
    if(isPossible(nums,start+1,sum3,sum5+tmp)) return true;
  }
  return false;
}